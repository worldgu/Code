package com.zero.juc.c_020;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName T06_TestCountDownLatch
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/26 0:03
 * @Version 1.0
 */
public class T06_TestCountDownLatch {

    /**
     *  CountDownLatch   直译 就是 倒数   Latch ->>>> 门栓
     *
     *  作用于多个线程之间的 倒数 计时 ，
     *              可以控制 主线程在什么的时候，继续执行下去，
     *  主要方法为为
     *          conuntDown(); // 每调用一次在原有的基础上减一
     *          await();      // 等待计数结束
     *
     *  CountDownLatch 的用法 比使用  Thread 的 join 的这种方式等待线程执行结束的方式更加灵活
     *
     * @param args
     */
    public static void main(String[] args) {
        usingJoin();
        usingCountDownLatch();
    }
    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        //
        for ( int i = 0; i < threads.length ; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0;j<1_0000 ; j++) result +=j;
                latch.countDown();
            });
        }

        for ( int i = 0; i<threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");

    }

    private static void usingJoin(){
        Thread[] threads = new Thread[100];

        for ( int i = 0; i< threads.length ; i++){
            threads[i] = new Thread(()->{
                int result = 0 ;
                for (int j = 0 ; j < threads.length; j++) result +=j;

            });
        }

        for ( int i = 0; i<threads.length ; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join ");
    }
}
