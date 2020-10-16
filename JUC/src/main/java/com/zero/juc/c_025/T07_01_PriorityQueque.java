package com.zero.juc.c_025;

import java.util.PriorityQueue;

/**
 * @ClassName T07_01_PriorityQueque
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 22:20
 * @Version 1.0
 */
public class T07_01_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("a");
        q.add("b");
        q.add("c");
        q.add("d");
        q.add("e");
        q.add("f");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

        System.out.println(q.size());
    }
}
