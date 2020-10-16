package com.zero.juc.c_001;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:29
 * @Version 1.0
 */
public class T {

    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o){  // 任何线程要执行下面的代码，必须要先拿到o 的锁
            count --;
            System.out.println(Thread.currentThread().getName() + "count = " +count);
        }
    }
}
