package com.zero.lockdemo.service.impl;

import com.zero.lockdemo.service.GrabService;
import com.zero.lockdemo.service.OrderService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName GrabRedissonServiceImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/17 17:23
 * @Version 1.0
 */
public class GrabRedissonServiceImpl implements GrabService {

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    Redisson redisson;

    @Autowired
    OrderService orderService;

    @Override
    public String getOrder(int orderId, int driverId) {
        // 生成Key
        String lock = "order_" + (orderId+"");

        RLock rLock = redissonClient.getFairLock(lock.intern());

//        RLock lock1 = redisson.getLock(lock.intern());

        try {
            // 此代码默认，设置key  超时时间30秒，过10秒，在延时
            rLock.lock();

//            lock1.lock();

            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            lock1.lock();

            System.out.println("司机：" + driverId + " 执行抢单逻辑");

            boolean b = orderService.grab(orderId,driverId);
            if (b) {
                System.out.println("司机:" + driverId + " 抢单成功");
            } else {
                System.out.println("司机:" + driverId + " 抢单失败");
            }

        } finally {
            rLock.unlock();
//            lock1.unlock();
        }
        return null;
    }
}
