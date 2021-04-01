package com.zero.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName T07_TestCyclicBarrier
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/26 0:17
 * @Version 1.0
 */
public class T07_TestCyclicBarrier {

    /**
     *  CyclicBarrier 栅栏  >>>>  当执行数到阈值时，执行CyclicBarrier 中的方法
     * @param args
     */
    public static void main(String[] args) {
//        CyclicBarrier barrier = new CyclicBarrier(20);

        CyclicBarrier barrier = new CyclicBarrier(20,()->System.out.println("满人"));

        /*CyclicBarrier barrier = new CyclicBarrier(20,new Runnable(){
            @Override
            public void run() {
                System.out.println("人满，发车");
            }
        });
*/
        for ( int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
