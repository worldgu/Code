package com.zero.lockdemo.service.impl;

import com.zero.lockdemo.service.GrabService;
import com.zero.lockdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName GrabRedisLockServiceImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/17 15:36
 * @Version 1.0
 */
@Service("grabRedisLockService")
public class GrabRedisLockServiceImpl implements GrabService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    OrderService orderService;

    @Override
    public String getOrder(int orderId, int driverId) {
        // 生成 Key
        String lock = "order_" + (orderId+"");

        /**
         * 情况一： 如果锁没执行到释放，比如业务逻辑执行一半，运维重启服务，或服务挂了，没有走finally，怎么办?
         * 加超时实践
         * sentx
         */
//        boolean lockStatus = stringRedisTemplate.opsForValue().setIfAbsent(lock.intern(), driverId+"");
//        if ( !lockStatus ) {
//            return null;
//        }

        /**
         * 情况二： 加超时时间，会有加不上的情况，运维重启
         *
         */
//        boolean lockStatus = stringRedisTemplate.opsForValue().setIfAbsent(lock.intern(),driverId+"");
//        stringRedisTemplate.expire(lock.intern(),30L, TimeUnit.SECONDS);
//        if (!lockStatus) {
//            return null;
//        }

        /**
         * 情况三： 超时时间应该一次加，不应该分2行代码
         */
        boolean lockStatus = stringRedisTemplate.opsForValue().setIfAbsent(lock.intern(),driverId+"",30L,TimeUnit.SECONDS);
        // 开个子线程，原来时间N，每个n/2,去续上N

        if (!lockStatus) {
            return null;
        }

        try {
            System.out.println("司机 ：" + driverId + " 执行抢单逻辑");

            boolean b = orderService.grab(orderId,driverId);
            if (b) {
                System.out.println("司机：" + driverId + " 抢单成功");
            } else {
                System.out.println("司机：" + driverId + "抢单失败");
            }
        } finally {
            /**
             * 这种释放锁，有可能释放了别人的锁
             */
//            stringRedisTemplate.delete(lock.intern());
            if ((driverId+"").equals(stringRedisTemplate.opsForValue().get(lock.intern()))) {
                stringRedisTemplate.delete(lock.intern());
            }
        }
        return null;
    }
}
