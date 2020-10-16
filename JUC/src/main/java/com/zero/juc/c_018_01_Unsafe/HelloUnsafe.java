package com.zero.juc.c_018_01_Unsafe;

import sun.misc.Unsafe;

/**
 * @ClassName HelloUnsafe
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/25 16:52
 * @Version 1.0
 */
public class HelloUnsafe {

    static class M {
        private M(){}
        int i = 0;
    }

    /**
     *
     * Unsafe 在 1.8 之后无法直接调用 ，只能通过反射的方法
     *
     *
     * @param args
     * @throws InstantiationException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws InstantiationException, ClassNotFoundException, NoSuchMethodException {
        Object unsafe = Class.forName(String.valueOf(Unsafe.class)).getMethod("unsafe");//   Unsafe.getUnsafe();

        M m = (M)((Unsafe)unsafe).allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
