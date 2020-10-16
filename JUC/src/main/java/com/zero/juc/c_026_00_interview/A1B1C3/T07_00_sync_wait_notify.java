package com.zero.juc.c_026_00_interview.A1B1C3;

/**
 * @ClassName T06_00_sync_wait_notify
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:33
 * @Version 1.0
 */
public class T07_00_sync_wait_notify {

    private static volatile boolean t2Started = false;

    // private static CountDowntLatch latch = new C(1);

    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        new Thread(()->{
            // latch.await();

            synchronized(o) {

                while (!t2Started) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                for (char c : aI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait(); // 让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notify(); // 必须，否则程序无法停止
            }
        },"t1").start();

        new Thread(()->{

            synchronized(o) {
                for (char c: aC) {

                    System.out.print(c);
                    t2Started = true;

                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notify();
            }
        },"t2").start();
    }
}
