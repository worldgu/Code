package com.zero.juc.c_025;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName T01_ConcurrentMap
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:20
 * @Version 1.0
 */
public class T01_ConcurrentMap {

    public static void main(String[] args) {
//        Map<String,String> map = new ConcurrentHashMap<>(); // 179  12920
//        Map<String,String> map = new ConcurrentSkipListMap<>(); //  高并发并排序   49  120

//        Map<String,String> map = new Hashtable<>();  // 125  1552
//        Map<String,String> map = new HashMap<>();  // Collections.synchronizedXXX  65 153
        Map<String,String>  map = new TreeMap<>(); // 94  253




        Random r = new Random();
        Thread[] ths = new Thread[100];

        CountDownLatch latch  = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();

        for ( int i = 0 ; i < ths.length; i++) {
            ths[i] = new Thread(()->{
                for ( int j = 0; j < 10000; j++){
                    map.put("a" + r.nextInt(10_0000), "a" + r.nextInt(10_0000));
                    latch.countDown();
                }
            });
        }

        Arrays.asList(ths).forEach(t->t.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());

    }
}
