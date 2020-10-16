package com.zero.juc.c_020;

import com.zero.juc.c_009.T;

import java.util.concurrent.Semaphore;

/**
 * @ClassName T11_TestSemaphore
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 16:59
 * @Version 1.0
 */
public class T11_TestSemaphore {

    public static void main(String[] args) {
//        Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2,true);

        // 允许一个线程同时执行
//        Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T1 running .....");
                Thread.sleep(200);
                System.out.println("T1 running .....");
            } catch ( InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(()-> {
            try {
                s.acquire();

                System.out.println("T2 running .....");
                Thread.sleep(200);
                System.out.println("T2 running .....");

            }  catch (InterruptedException e) {
               e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

    }

}
