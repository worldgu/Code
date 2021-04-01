package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.*;

/**
 * @ClassName T03_Callable
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:17
 * @Version 1.0
 */
public class T03_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable(){
            @Override
            public Object call() throws Exception {
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(c); // 异步

        System.out.println(future.get());  // 阻塞

        service.shutdown();
    }
}
