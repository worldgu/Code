package com.zero.observer;

/**
 * 电话事件观察者接口抽象
 *
 * @ClassName PhoneCallEventListener
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 21:27
 * @Version 1.0
 */
public interface PhoneCallEventListener {

    void makePhoneCall (AbstractEvent e);
}
