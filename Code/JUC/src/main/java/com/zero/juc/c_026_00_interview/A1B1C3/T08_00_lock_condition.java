package com.zero.juc.c_026_00_interview.A1B1C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T08_00_lock_condition
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:37
 * @Version 1.0
 */
public class T08_00_lock_condition {
    public static void main(String[] args) {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch ( Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch ( Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
