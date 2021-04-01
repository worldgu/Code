package com.zero.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T13_TestLockSupport
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 17:39
 * @Version 1.0
 */
public class T13_TestLockSupport {

    public static void main (String[] args) {
        //使用 lombda 表达式 创建一个线程 t
        Thread t = new Thread(()->{
            for ( int i = 0 ; i < 10 ; i++) {
                System.out.println(i);
                if ( i == 5 ) {
                    // 使用LockSupport 的park() 方法 阻塞当前线程t
                    LockSupport.park();
                }

                try {
                    // 使当前线程t 休眠 1秒
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 启动当前线程t
        t.start();

        LockSupport.unpark(t);


    }
}
