package com.zero.juc.c_023_02_FromHashtableToCHM;

import java.util.*;

/**
 * @ClassName T01_TestHashtable
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 21:22
 * @Version 1.0
 */
public class T03_TestSynchronizedHashMap {

    static Map<UUID, UUID> m = Collections.synchronizedMap(new HashMap<UUID,UUID>());

    static int count = Constants.COUNNT;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];
    static final int THREAD_COUNT = Constants.THREAD_COUNT;

    static {
        for (int i =0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start;
        int gap = count/THREAD_COUNT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for ( int i = start; i < start+gap; i++) {
                m.put(keys[i], values[i]);
            }
            super.run();
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for ( int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread( i * (count/THREAD_COUNT));
        }

        for ( Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(m.size());

        // ---====-------------------====

        start = System.currentTimeMillis();
        for ( int i = 0 ; i < threads.length ; i++) {
            threads[i] = new Thread(()->{
                for ( int j = 0; j < 1000_0000 ; j++) {
                    m.get(keys[10]);
                }
            });
        }


        for ( Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(m.size());
    }
}
