package com.zero.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName T04_ConcurrentQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:55
 * @Version 1.0
 */
public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for ( int i = 0; i <10; i++ ) {
            strs.offer("a" + i ) ; // 添加
        }

        System.out.println(strs);

        System.out.println(strs.size());

        //  poll 弹出最下面的元素
        System.out.println(strs.poll());
        System.out.println(strs.size());

        // 读取最下面的元素
        System.out.println(strs.peek());
        System.out.println(strs.size());
    }
}
