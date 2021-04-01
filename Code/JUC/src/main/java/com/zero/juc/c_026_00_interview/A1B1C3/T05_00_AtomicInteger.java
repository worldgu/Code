package com.zero.juc.c_026_00_interview.A1B1C3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName T05_00_AtomicInteger
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:30
 * @Version 1.0
 */
public class T05_00_AtomicInteger {

    static AtomicInteger threadNo = new AtomicInteger(1);

    public static void main(String[] args) {

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        new Thread(()->{
            for (char c : aI) {
                while (threadNo.get() != 1) {}
                System.out.print(c);
                threadNo.set(2);
            }
        },"t1").start();

        new Thread(()->{
            for (char c: aC) {
                while (threadNo.get() != 2) {}
                System.out.print(c);
                threadNo.set(1);
            }
        },"t2").start();

    }
}
