package com.zero.juc.c_003;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:34
 * @Version 1.0
 */
public class T {

    private int count = 10;

    // 等同于在方法的代码执行时要synchronized(this)
    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);

    }
}
