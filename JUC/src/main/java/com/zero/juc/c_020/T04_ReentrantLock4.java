package com.zero.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T04_ReentrantLock4
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 20:34
 * @Version 1.0
 */
public class T04_ReentrantLock4 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread (() -> {
            try {
                lock.lock();
                System.out.println("t1.... start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1.... end");
            } catch ( InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread (() -> {
            try {
//                lock.lock();
                lock.lockInterruptibly(); //  可以对interrupt() 方法做出响应
                System.out.println("t2.... start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t2.... end");
            } catch ( InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();

    }
}
