package com.zero.juc.c_025;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName T02_CopyOnWriteList
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:35
 * @Version 1.0
 */
public class T02_CopyOnWriteList {

    public static void main(String[] args) {

        List<String> lists =
//                new ArrayList<>();  // 533   54_5340  这个回 出现并发的问题
//                new Vector<>();    //  464  100_0000
                new CopyOnWriteArrayList<>();  // 9195  10_0000   应该是牵扯到了内存地址的移动所以效率很慢

        Random r = new Random();
        Thread[] ths = new Thread[100];

        for ( int i = 0 ; i < ths.length ; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for ( int i = 0 ; i < 1000 ; i++) {
                        lists.add("a" + r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }
        
        runAndComputeTime(ths);
        System.out.println(lists.size());
    }

    private static void runAndComputeTime(Thread[] ths) {
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long s2 = System.currentTimeMillis();
        System.out.println(s2-s1);
    }
}
