package com.zero.lockdemo.service.impl;

import com.zero.lockdemo.service.RenewGrabLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RenewGrabLockServiceImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/17 17:30
 * @Version 1.0
 */
public class RenewGrabLockServiceImpl implements RenewGrabLockService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    @Async
    public void renewLock(String key, String value, int time) {
        String v = redisTemplate.opsForValue().get(key);
        if (v.equals(value)) {
            int sleepTiem = time/3;
            try {
                Thread.sleep(sleepTiem * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            renewLock(key,value,time);
        }
    }
}
