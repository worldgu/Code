package com.zero.juc.c_005;

/**
 *
 *  volatile  保证线程之间的可见性，不保证原子性
 *  synchronized 保证线程之间的可见性，并且保证原子性
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:40
 * @Version 1.0
 */
public class T implements Runnable{

    private /*volatile*/ int count = 100;

    public synchronized void run () {
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i<100; i++) {
            new Thread(t,"Thread" + i).start();
        }
    }
}
