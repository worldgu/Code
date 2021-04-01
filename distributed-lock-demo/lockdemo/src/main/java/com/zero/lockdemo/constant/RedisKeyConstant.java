package com.zero.lockdemo.constant;

/**
 * @ClassName RedisKeyConstant
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/17 15:57
 * @Version 1.0
 */
public class RedisKeyConstant {

    /**
     * 抢单key前缀
     */
    public static final String GRAB_LOCK_ORDER_KEY_PRE = "lock_";

    /**
     * 司机抢单前缀
     */
    public static final String DRIVER_LISTEN_ORDER_PRE = "driver_order_list_";

}
