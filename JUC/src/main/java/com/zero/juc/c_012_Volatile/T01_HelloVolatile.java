package com.zero.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

/**
 *
 * volatile  关键字  ，是一个变量在多线程的间可见
 * A   B 线程都用到了一个变量， java 默认是 A线程 中保留一份 copy ,这样如果线程 B 修改变量，则A 线程未必知道
 *
 * 使用volatile 关键字，会让所有线程都会 读到变量的修改值
 *
 * 在下面的代码中，running 是存在于堆内存的 t对象中
 * 当线程 t1 开始运行的时候，会把running 值从内存中读到 t1 线程的工作区，在运行过程中直接使用这个 copy，
 * 并不会每次都去 读取内存，这样，当线程修改ruuning的之后，t1 线程感知不到，所以不会停止运行
 *
 * 使用volatile ,将会强制所有线程 都会去 堆内存中读取running 的值
 *
 * 可以阅读这个文章加深讲解
 *
 * http://www.cnblongs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 * volatile 并不能保证多个线程共同修改running 变量时多带来的不一致问题，也就是说 volatile 不能提带 synchroinzed
 *
 *
 */

/**
 * @ClassName T01_HelloVolatile
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 20:35
 * @Version 1.0
 */
public class T01_HelloVolatile {

    /*volatile*/ boolean running = true ; // 对比一下有无volatile 的情况下，整个程序运行结果的区别
    void m(){
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");

    }

    public static void main(String[] args) {
         T01_HelloVolatile t = new T01_HelloVolatile();

         new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;

    }
}
