package com.zero.juc.c_000;

/**
 *  创建线程的几种方法
 *
 *@ClassName T02_HowToCreateThread
 *@Description TODO
 *@Author 张春海
 *@Date 2020/9/21 16:56
 *@Version 1.0 */
public class T02_HowToCreateThread {

    /**
     *  继承 Thread  进行实现
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hellp MyThread!");
        }
    }

    //  实现  Runnable 接口进行实现
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();
    }

}
