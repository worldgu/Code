package com.zero.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T02_VolatileRefernce1
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 0:59
 * @Version 1.0
 */
public class T02_VolatileRefernce1 {

    boolean running = true;

    volatile static T02_VolatileRefernce1 T = new T02_VolatileRefernce1();

    void m(){
        System.out.println("m start");
        while (running) {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            // 注释sleep  方法后， 方法运行将不会结束， 说 T 中的running 变量在线程 之间无法 即时通知所有线程
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Thread(T::m,"T1").start();

        // lambda 表达式 new Thread(new Runnable (run() {m()}))

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T.running = false;
    }
}
