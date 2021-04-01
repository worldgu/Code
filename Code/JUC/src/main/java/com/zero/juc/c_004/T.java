package com.zero.juc.c_004;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:38
 * @Version 1.0
 */
public class T {

    private static int count = 10;

    // 这里等同于synchronized(FineCoarseLock.class)
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm(){
        synchronized (T.class) {
            count--;
        }
    }
}
