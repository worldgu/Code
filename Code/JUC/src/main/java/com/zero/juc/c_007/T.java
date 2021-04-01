package com.zero.juc.c_007;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:50
 * @Version 1.0
 */
public class T {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start ...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end ");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName() + " m2 start ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2  end");

    }

    public static void main(String[] args) {

        T t = new T();
        // 启动 Runnable 线程的三种写法

        // 1. 普通写法
//        new Thread(()->{t.m1(),"t1"}).start();
//        new Thread(()->{t.m2(),"t2"}).start();

        // 2. 增强的写法
        new Thread(t::m1, "t1").start();
        new Thread(t::m2,"t2").start();

        // 1.8 之前的写法
//        new Thread(new Runnable() {
//            @Override
//            public void run(){
//                t.m1();
//            }
//        }).start();

    }
}
