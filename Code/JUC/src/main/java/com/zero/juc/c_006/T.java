package com.zero.juc.c_006;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 19:46
 * @Version 1.0
 */
public class T implements Runnable{

    private int count = 10;

    public synchronized void run(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i<5;i++) {
            T t = new T();
            // 这里是 实例化了多个的  线程，互相之间并不干扰
            // 所以T值之间互不干扰
            //Thread0 count = 9
            //Thread1 count = 9
            //Thread2 count = 9
            //Thread3 count = 9
            //Thread4 count = 9
            new Thread(t,"Thread" + i).start();
        }
    }
}
