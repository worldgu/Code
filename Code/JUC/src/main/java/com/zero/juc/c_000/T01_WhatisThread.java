package com.zero.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 *@ClassName T01_WhatisThread
 *@Description TODO
 *@Author 张春海
 *@Date 2020/9/21 16:54
 *@Version 1.0 */
public class T01_WhatisThread {


    /**
     * 通过  继承 Thread 重写run
     */
    private static class T1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    // 设置睡眠时间
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch ( InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        new T1().run();  //  这种方式只是调用方式  并没有启动多线程
        //  调用start()  开启多线程
        new T1().start();
        for (int i = 0; i < 10 ; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
            System.out.println("main");

        }

    }




}
