package com.zero.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T02_ReentrantLock3
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 20:21
 * @Version 1.0
 */
public class T03_ReentrantLock3 {
    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();  // 等同于 synchronized(this)
            for  (int i = 0 ; i < 10 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据tryLock 的返回值来判断是否锁定
     * 也可以执行tryLock 的时间，由于tryLock(time) 抛出异常，所以要注释unLock的处理，必须放到finally 中
     *
     */
    void m2 () {
//        boolean locked = lock.tryLock();
//        System.out.println("m2 ..." + locked);
//        if(locked) lock.unlock();

        boolean locked = false;

        try {
            locked  = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2..." + lock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T03_ReentrantLock3 r1 = new T03_ReentrantLock3();

        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();

    }


}
