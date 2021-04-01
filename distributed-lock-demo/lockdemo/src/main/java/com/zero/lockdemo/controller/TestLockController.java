package com.zero.lockdemo.controller;

import com.zero.lockdemo.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestLockController
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/13 23:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/grab")
public class TestLockController {

    @Value("port")
    private String port;

    /**
     * 通过注解指定不同的显示
     */
    @Autowired
    // 无锁
    @Qualifier("grabNoLockService")
    // jvm锁
//    @Qualifier("grabJvmLockService")
    // mysql锁
//    @Qualifier("grabMysqlLockService")
    // 手写redis
//    @Qualifier("grabRedisLockService")
    // 单个redisson
//    @Qualifier("grabRedisRedissonLockService")
    // 红锁
//    @Qualifier("grabRedisRedissonRedLockLockService")
    private GrabService grabService;


    public String testLock (@PathVariable("orderId") int orderId,int driverId) {
        System.out.println("Port " + port +"OrderId :" + orderId + ", driverId : " + driverId);
        grabService.getOrder(orderId,driverId);

        return "";

    }
}
