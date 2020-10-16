package com.zero.juc.c_011;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 20:20
 * @Version 1.0
 */
public class T {

    int count = 0;

    synchronized void m (){
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count ++ ;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ( count == 5 ) {
                int i =1/0;  // 此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch ,然后然循环继续
                System.out.println(i);
            }

        }
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t::m,"t2").start();

    }
}
