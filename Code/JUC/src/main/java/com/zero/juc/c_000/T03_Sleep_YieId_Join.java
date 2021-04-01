package com.zero.juc.c_000;

//import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.concurrent.TimeUnit;

/**
 *
 *  线程中的  方法调用
 *
 *
 * @ClassName T03_Sleep_YieId_Join
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 16:59
 * @Version 1.0
 */
public class T03_Sleep_YieId_Join {

    public static void main(String[] args) {
//        System.out.println("进行Sleep的方法调用");
//        testSleep();
//        System.out.println("进行Yield的方法调用");
//        testYield();
//        System.out.println("进行Join的方法调用");
        testJoin();
    }

    /**
     *  调用 sleep 方法
     *  sleep 不是 释放锁，睡眠一定时间后 继续执行
     */
    static void testSleep() {
        new Thread(()-> {
           for ( int i = 0; i<100;i++) {
               System.out.println("A" + i);
               try {
                   TimeUnit.MICROSECONDS.sleep(500);
               } catch ( InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
    }


    /**
     *   yield  释放锁   然后进入等待对列   与其他线程竞争  资源
     *
     */
    static void testYield(){
        new Thread(() -> {
            for ( int i = 0; i<100;i++) {
                System.out.println("A" + i);
                if (i%10 == 0 ) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for ( int i = 0; i<100;i++) {
                System.out.println("--------------B" +i);
                if (i%10 ==0 ) Thread.yield();
            }
        }).start();
    }


    /**
     *  join   可以使线程之间 顺序执行
     *
     *  在  B线程中  进行 A.join()  调用时，只有等A线程运行完之后，
     *                           才能进行B线程任务的执行
     *
     */
    static void testJoin () {
        Thread t1 = new Thread(()->{
            for ( int i = 0; i<100;i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch ( InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread t2 = new Thread(()->{

            try {
                t1.join();
            } catch ( InterruptedException e) {
                e.printStackTrace();
            }

            for ( int i = 0; i<100;i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                } catch ( InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();
    }



}
