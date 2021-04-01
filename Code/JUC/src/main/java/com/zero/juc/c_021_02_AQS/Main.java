package com.zero.juc.c_021_02_AQS;

import java.util.concurrent.locks.Lock;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 23:33
 * @Version 1.0
 */
public class Main {
    public  static int m = 0;
    public static Lock lock = new MLock();

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length ; i++) {
            threads[i] = new Thread(()->{
                try {
                    lock.lock();
                    for (int j = 0 ; j < 100 ; j++) {
                        m++;
                    }
                }  finally {
                    lock.unlock();
                }
            });

        }

        for (Thread t : threads ) {t.start();};
        for (Thread t : threads ) {t.join();};

        System.out.println(m);
    }
}
