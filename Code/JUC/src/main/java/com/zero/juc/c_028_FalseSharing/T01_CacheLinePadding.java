package com.zero.juc.c_028_FalseSharing;

/**
 * @ClassName T01_CacheLinePadding
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 20:20
 * @Version 1.0
 */
public class T01_CacheLinePadding {
    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();  // 一个线程启动两次，会提示 不恰当的操作状态   IllegalThreadStateException
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() -start)/100_0000); // 499
    }
}