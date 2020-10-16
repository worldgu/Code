package com.zero.juc.c_026_00_interview.A1B1C3;

/**
 * @ClassName T02_00_LockSupport
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:04
 * @Version 1.0
 */

import java.util.concurrent.locks.LockSupport;

/**
 *  lockSupport park 当前线程阻塞 (停止)
 *  unpark(Thread t)
 */
public class T02_00_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char c :
                 aC) {
                System.out.println(c);
                LockSupport.unpark(t2); // 叫醒T2
                LockSupport.park(); // T1 阻塞
            }
        },"t1");

        t2 = new Thread(()->{

            for (char c:
                 aI) {
                LockSupport.park();   // 阻塞t2
                System.out.println(c);
                LockSupport.unpark(t1); // 叫醒 t1
            }
        });

        t1.start();
        t2.start();


    }
}
