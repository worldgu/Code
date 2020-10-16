package com.zero.juc.c_018_00_AtomicXXX;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName T03_SyncVsLongAdder
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 0:46
 * @Version 1.0
 */
public class T03_SyncVsLongAdder {

    static long count2 = 0L;
    static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[500];

        for (int i = 0; i < threads.length; i++) {
            threads[i] =
                    new Thread(()->{
                        for (int k = 0; k < 10_0000;k++) count.increment();
                    });
        }

        long start = System.currentTimeMillis();

        for ( Thread t : threads ) t.start();

        for ( Thread t : threads ) t.join();

        long end = System.currentTimeMillis();

        // TimeUnit.SECONDS.sleep(10);

        System.out.println("LongAdder: " + count.longValue() + " time " + (end-start));
        // -----------------------------------------------
        Object lock = new Object();

        for ( int i =0 ; i < threads.length ; i++) {
            threads[i] = new Thread (new Runnable() {
                @Override
                public void run() {
                    for ( int k = 0; k < 10_000; k++) {
                        synchronized (lock) {
                            count2++;
                        }
                    }
                }
            });
        }

        start = System.currentTimeMillis();

        for ( Thread t : threads ) t.start();

        for ( Thread t : threads ) t.join();

        end = System.currentTimeMillis();

        // TimeUnit.SECONDS.sleep(10);

        System.out.println("Sync: " + count2 + " time " + (end-start));
    }
}
