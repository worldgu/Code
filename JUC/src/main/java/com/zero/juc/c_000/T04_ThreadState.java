package com.zero.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * 获取线程状态
 *
 * @ClassName T04_ThreadState
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 18:07
 * @Version 1.0
 */
public class T04_ThreadState {

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("1:当前状态为>>>>>"+this.getState());
            for ( int i = 0; i<100;i++) {
                try {
                    System.out.println("4:当前状态为>>>>>"+this.getState());
                    Thread.sleep(500);
                    System.out.println("5:当前状态为>>>>>"+this.getState());
                } catch ( InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        new Thread(()->{
            for (;;) {
                try {
                    TimeUnit.MICROSECONDS.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前状态为>>>>>>>>>>>" + t.getState());
            }
        }).start();
        System.out.println("2:"+t.getState());

        t.start();

        try {
            t.join();
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("3:"+t.getState());
    }

}
