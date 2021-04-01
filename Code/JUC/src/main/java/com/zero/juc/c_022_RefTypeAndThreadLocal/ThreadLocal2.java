package com.zero.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal1
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 20:59
 * @Version 1.0
 */
public class ThreadLocal2 {
//    volatile static Person p = new Person();
    static ThreadLocal<Person> t1 = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(p.name);
            System.out.println(t1.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            p.name = "list";
            t1.set(new Person());
        }).start();

    }

    static class Person {
        public String name = "zhangsan";
    }

}

