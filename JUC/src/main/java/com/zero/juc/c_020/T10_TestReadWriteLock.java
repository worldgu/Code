package com.zero.juc.c_020;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName T10_TestReadWriteLock
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 16:44
 * @Version 1.0
 */
public class T10_TestReadWriteLock {

    static Lock lock = new ReentrantLock();

    private static int  value;

    // 读写锁 相对于使用ReentrantLock()  这种锁的方式，性能有所提升
    static ReadWriteLock readWriterLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriterLock.readLock();
    static Lock writeLock = readWriterLock.writeLock();

    public static void read (Lock lock) {

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over! ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("read over! ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        Runnable readR = ()->read(lock);
        Runnable readR = ()->read(readLock);

//        Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR =  ()-> write(writeLock, new Random().nextInt());

        for ( int i = 0 ; i < 18 ; i++ ) new Thread(readR).start();
        for ( int i = 0 ; i < 2 ; i++ ) new Thread(writeR).start();

    }
}
