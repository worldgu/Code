package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.*;

/**
 * @ClassName T14_MyRejectedHandler
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:48
 * @Version 1.0
 */
public class T14_MyRejectedHandler {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(4,4,0,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new MyHandler());
    }

    static class MyHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if ( executor.getQueue().size() < 10000) {

            }
        }
    }
}
