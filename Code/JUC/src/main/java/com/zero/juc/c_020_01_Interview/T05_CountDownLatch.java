package com.zero.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T04_NotifyFreeLock
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 18:20
 * @Version 1.0
 */
public class T05_CountDownLatch {

    // 添加volatile, 使 t2 能够得到通知
    volatile List lists = new ArrayList<>();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T05_CountDownLatch c = new T05_CountDownLatch();

        CountDownLatch latch  = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("t2 启动");
            if (c.size() != 5){
                try {
                    latch.await();
                    // 也可以指定等待时间
                    latch.await(5000,TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("t2 结束");
            // 通知t1继续执行
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 启动");
            for ( int  i = 0 ; i < 10 ; i++ ) {
                c.add(new Object());
                System.out.println("add " + i);

                if ( c.size() == 5) {
                    // 打开门闩 ，让t2 得以运行
                    latch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1").start();
    }
}
