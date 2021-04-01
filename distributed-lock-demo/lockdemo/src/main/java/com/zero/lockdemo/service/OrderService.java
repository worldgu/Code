package com.zero.lockdemo.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/14 19:35
 * @Version 1.0
 */
@Service("orderSerivce")
public interface OrderService {

    public boolean grab(int orderId, int driverId);

}
