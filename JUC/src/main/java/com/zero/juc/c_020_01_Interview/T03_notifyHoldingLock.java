package com.zero.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T03_notifyHoldingLock
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 18:06
 * @Version 1.0
 */
public class T03_notifyHoldingLock {

    // 添加volatile, 使 t2 能够得到通知
    volatile List lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T03_notifyHoldingLock c = new T03_notifyHoldingLock();

        final Object lock = new Object();

        new Thread(()->{
            synchronized(lock){
                System.out.println("t2 启动");
                if (c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread (()->{
            System.out.println("t1 启动");

            synchronized(lock){
                for ( int i = 0 ; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " +i);

                    if (c.size() ==5) {
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1").start();
    }

}
