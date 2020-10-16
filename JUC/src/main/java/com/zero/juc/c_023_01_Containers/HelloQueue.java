package com.zero.juc.c_023_01_Containers;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName HelloQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 21:13
 * @Version 1.0
 */
public class HelloQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayBlockingQueue<>(2);

        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
    }
}
