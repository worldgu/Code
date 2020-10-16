package com.zero.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * reentrantlock  用于替代 synchronized
 * 由于m1 锁定this ,只有 m1 执行完毕的时候， m2 才能执行
 * 这里是复习synchronized 最原始的语义
 *
 * 使用reentrantlock 可以完成同样的功能
 * 需要注意的是，必须要手动释放锁
 * 使用syn锁定的话 如果遇到异常， jvm 会手动的释放锁，但是lock必须手动释放锁
 * @ClassName T02_ReentrantLock2
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 20:08
 * @Version 1.0
 */
public class T02_ReentrantLock2 {

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

    void m2 () {
        try {
            lock.lock();
            System.out.println("m2 ......");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T02_ReentrantLock2 r1 = new T02_ReentrantLock2();

        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();

    }

}
