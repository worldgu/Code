package com.zero.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T06_LockSupport
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 19:52
 * @Version 1.0
 */
public class T08_Semaphore {


    // 添加volatile, 使 t2 能够得到通知
    volatile List lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        T08_Semaphore c = new T08_Semaphore();
        Semaphore s = new Semaphore(1);

        t1 = new Thread(()->{
            try {
                s.acquire();
                for ( int i = 0; i <5; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);

                }
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                t2.start();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                s.acquire();
                for ( int i = 5; i <10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);

                }
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"t1");

        t2 = new Thread(()->{
            try {
                s.acquire();
                System.out.println("t2结束");
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2");

        t1.start();

    }
}
