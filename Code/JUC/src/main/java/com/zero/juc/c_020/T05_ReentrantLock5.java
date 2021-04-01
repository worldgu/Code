package com.zero.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T05_ReentrantLock5
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 20:56
 * @Version 1.0
 */
public class T05_ReentrantLock5 extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true); // 参数为true表时为公平锁，请对比输出结果

    public void run(){
        for ( int i = 0 ; i < 100 ; i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
         T05_ReentrantLock5 r1 = new T05_ReentrantLock5();
         Thread t1 = new Thread(r1);
         Thread t2 = new Thread(r1);
         t1.start();
         t2.start();
    }
}
