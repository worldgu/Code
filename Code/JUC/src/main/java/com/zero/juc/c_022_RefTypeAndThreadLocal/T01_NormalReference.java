package com.zero.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @ClassName T01_NormalReference
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 0:07
 * @Version 1.0
 */
public class T01_NormalReference {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;

        System.gc();

        System.in.read();
    }
}
