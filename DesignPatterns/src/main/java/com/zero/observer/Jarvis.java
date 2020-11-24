package com.zero.observer;

/**
 * 观察者实现
 *
 * @ClassName Jarvis
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:30
 * @Version 1.0
 */
public class Jarvis implements WakeupEventListener,PhoneCallEventListener{

    @Override
    public void makePhoneCall(AbstractEvent e) {
        System.out.println("Jarvis -- Yes Sir ! Calling Miss peper");
    }

    @Override
    public void answerTonyStark(AbstractEvent e) {
        System.out.println("Jarvis -- ready for you ,Sir");
    }
}
