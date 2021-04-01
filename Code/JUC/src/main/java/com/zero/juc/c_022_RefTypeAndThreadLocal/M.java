package com.zero.juc.c_022_RefTypeAndThreadLocal;

/**
 * @ClassName M
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 0:06
 * @Version 1.0
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
