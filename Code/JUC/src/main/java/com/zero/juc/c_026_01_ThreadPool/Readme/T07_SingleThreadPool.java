package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName T07_SingleThreadPool
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:56
 * @Version 1.0
 */
public class T07_SingleThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(()->{
                System.out.println(j + " " + Thread.currentThread().getState());
            });
        }
    }
}
