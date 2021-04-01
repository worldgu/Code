package com.zero.lockdemo.service.impl;

import com.zero.lockdemo.service.GrabService;
import com.zero.lockdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GrabNoLockServiceImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/14 19:34
 * @Version 1.0
 */
@Service("grabJvmLockService")
public class GrabJvmLockServiceImpl implements GrabService {


    @Autowired
    private OrderService orderService;
    
    @Override
    public String getOrder(int orderId, int driverId) {
        String lock = (orderId + "");

        synchronized (lock.intern()) {

            try {
                System.out.println(" 司机 :" + driverId);

                boolean b = orderService.grab(orderId,driverId);

                if ( b ) {
                    System.out.println("司机 :" + driverId + "抢单成功");
                } else {
                    System.out.println("司机 :" + driverId + " 抢单失败");
                }

            } finally {

            }
        }
        return null;
    }
}
