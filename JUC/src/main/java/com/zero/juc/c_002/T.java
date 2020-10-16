package com.zero.juc.c_002;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:31
 * @Version 1.0
 */
public class T {

    private int count = 10;

    public void m() {
        synchronized (this) {   // 任何线程要执行下面的 代码，必须先拿到this的锁
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
