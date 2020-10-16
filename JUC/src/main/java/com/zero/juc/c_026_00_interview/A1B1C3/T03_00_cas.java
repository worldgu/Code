package com.zero.juc.c_026_00_interview.A1B1C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T02_00_cas
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:12
 * @Version 1.0
 */
public class T03_00_cas {

    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun r = ReadyToRun.T1; // 思考为什么使用volatile

    public static void main(String[] args) {

        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        new Thread(()->{
            for (char c : aI) {
                while (r != ReadyToRun.T1) {}
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        },"t1").start();

        new Thread(()->{

            for (char c: aC) {
                while (r != ReadyToRun.T2) {}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        },"t2").start();
    }
}
