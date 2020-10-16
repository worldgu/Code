package com.zero.juc.c_027_future_to_loom;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName T01_Future
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:53
 * @Version 1.0
 */
public class T01_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(()->{
            return 8;
        });

        int i = future.get();

        System.out.println(i);
    }
}
