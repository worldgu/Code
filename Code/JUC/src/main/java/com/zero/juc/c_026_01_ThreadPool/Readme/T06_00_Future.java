package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T06_00_Future
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:37
 * @Version 1.0
 */
public class T06_00_Future {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> task = new FutureTask<>(()->{
                TimeUnit.MILLISECONDS.sleep(500);
                return 1000;
        });  //new Callable() {Integer call();}

        new Thread(task).start();

        System.out.println(task.get()); // 阻塞
    }
}
