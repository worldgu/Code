package com.zero.juc.c_018_00_AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  int  计数时，使用  AtomicInteger  可以 取代 volatile 以及  synchronized 的组合
 *  从名字 可以看出 AtomicInteger 是 原子操作， 高并发的情况可以保持一致
 *
 *  AtomicInteger 为什么会保持一致?
 *                  底层实现是CAS的操作， 即将现有值 于期望值 作比较 如果一致 进行下面的操作，如果不一致 执行下一次对比，直到条件成立
 *  AtomicInteger 是无锁操作，即 比 volatile和 synchronized的组合操作 ，更加节省系统资源的调度浪费
 *
 *
 *
 * @ClassName T01_AtomicInteger
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 22:43
 * @Version 1.0
 */
public class T01_AtomicInteger {

    volatile int count = 0;

//    AtomicInteger count = new AtomicInteger(0);

    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
          // if count1.get() <1000
//          count.incrementAndGet();  //  相当于 count1++
        }
    }

    public static void main(String[] args) {

        T01_AtomicInteger t = new T01_AtomicInteger();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10 ; i++) {
            threads.add(new Thread(t::m,"Thread - " + i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
