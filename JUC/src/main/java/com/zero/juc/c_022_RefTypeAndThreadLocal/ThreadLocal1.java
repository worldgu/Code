package com.zero.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal1
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/13 20:59
 * @Version 1.0
 */
public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "list";
        }).start();

    }


}

class Person {
    public String name = "zhangsan";
}
