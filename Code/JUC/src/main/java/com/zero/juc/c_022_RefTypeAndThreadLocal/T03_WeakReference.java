package com.zero.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

/**
 * @ClassName T03_WeakReference
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 20:42
 * @Version 1.0
 */
public class T03_WeakReference {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> t1 = new ThreadLocal<>();
        t1.set(new M());
        t1.remove();
    }
}
