package com.zero.juc.c_018_00_AtomicXXX;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName T02_AtomicVsSyncVsLongAdder
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 23:09
 * @Version 1.0
 */
public class T02_AtomicVsSyncVsLongAdder {

    static long count2 = 0L;
    static AtomicLong count1 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];

        for (int i = 0 ; i < threads.length ; i++) {
            threads[i] =
                    new Thread(()-> {
                        for (int k = 0; k < 10_0000; k++) count1.incrementAndGet();
                    });
        }

        long start = System.currentTimeMillis();

        for ( Thread t : threads ) t.start();

        for ( Thread t : threads ) t.join();

        long end = System.currentTimeMillis();

        // TimeUnit.SECONDS.sleep(10);

        System.out.println("Atomic: " + count1.get() + " time " + (end-start));

        // ------------------------------------------------

        Object lock = new Object();

        for ( int i =0 ; i < threads.length ; i++) {
            threads[i] = new Thread (new Runnable() {
                @Override
                public void run() {
                    for ( int k = 0; k < 10_0000; k++) {
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

        System.out.println("Sync: " + count1.get() + " time " + (end-start));

        // ---------------------------------

        for ( int i = 0; i < threads.length ; i++) {
            threads[i] =
                    new Thread(() -> {
                        for (int k = 0; k < 10_0000; k++) count3.increment();
                    });
        }

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

        System.out.println("LongAdder: " + count1.get() + " time " + (end-start));

    }

    static void microSleep(int m){
        try {
            TimeUnit.SECONDS.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
