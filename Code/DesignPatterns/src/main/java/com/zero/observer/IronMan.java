package com.zero.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * IronMan里  持有所有注册的观察者，生产事件 Event对象
 *
 * @ClassName IronMan
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 21:24
 * @Version 1.0
 */
public class IronMan {

    private List<WakeupEventListener> wakeupEventListeners = new ArrayList<>();

    private List<PhoneCallEventListener> phoneCallEventListeners = new ArrayList<>();

    public void addWakeupListener (WakeupEventListener listener) {
        wakeupEventListeners.add(listener);
    }

    public void addPhoneCallListener (PhoneCallEventListener listener) {
        phoneCallEventListeners.add(listener);
    }

    public void makePhoneCall (String name) {
        System.out.println("Iron Man -- call " + name);
        PhoneCallEvent phoneCallEvent = new PhoneCallEvent();
        for (PhoneCallEventListener phoneCallEventListener : phoneCallEventListeners) {
            phoneCallEventListener.makePhoneCall(phoneCallEvent);
        }
    }

    public void wakeupJarvis () {
        System.out.println("Iron Man -- Jarvis,are you online?");
        WakeupEvent wakeupEvent = new WakeupEvent();
        for (WakeupEventListener wakeupEventListener : wakeupEventListeners) {
            wakeupEventListener.answerTonyStark(wakeupEvent);
        }
    }
}
