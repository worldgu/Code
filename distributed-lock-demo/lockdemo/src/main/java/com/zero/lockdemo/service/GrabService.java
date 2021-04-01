package com.zero.lockdemo.service;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/13 23:29
 * @Version 1.0
 */
public interface GrabService {

    /**
     * 获取订单
     * @param orderId
     * @param driverId
     * @return
     */
    public String getOrder(int orderId, int driverId);
}
