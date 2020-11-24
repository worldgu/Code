package com.zero.observer;

/**
 *              观察者测试
 *
 *              观察者模式  （Observer）
 *
 *   观察者模式的运用场景非常多，事件的监听器Listener,钩子函数Hook,回调函数Callback本质上都是一种观察者模式的实现
 *
 * 观察者模式的实现特点
 *
 * 1.事件源对象，其中注册了一组或者多组监听器
 *
 * 2.事件对象，发生指定事件后，事件源生成具体的事件交给负责处理此类事件的监听器们
 *
 * 3.监听者对象，负责对已经发生的事件进行处理
 *
 * 简单理解在见面上点击一个button,js在监听到这个button被点击后就会产生一个点击事件，并交给对应的回调函数去处理，这就是一种观察者模式的具体运用
 *
 *
 *  https://blog.csdn.net/m0_47210154/article/details/105747932
 *
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:32
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        IronMan ironMan = new IronMan();
        Jarvis jarvisObserver = new Jarvis();
        // 注册观察者Jarvis
        ironMan.addPhoneCallListener(jarvisObserver);
        ironMan.addWakeupListener(jarvisObserver);
        // 生产事件
        ironMan.wakeupJarvis();
        ironMan.makePhoneCall("peper");
    }
}
