package com.zero.juc.c_023;

import java.util.Arrays;

/**
 * @ClassName Singletion
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 21:09
 * @Version 1.0
 */
public class Singletion {

    private Singletion(){
        System.out.println("single");
    }

    private static class Inner {
        private static Singletion s = new Singletion();
    }

    public static Singletion getSingle() {
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];

        for (int i = 0; i < ths.length ; i++) {
            ths[i] = new Thread(()->{
                System.out.println(Singletion.getSingle());
            });
        }

        Arrays.asList(ths).forEach(o->o.start());
    }
}
