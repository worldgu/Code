package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T11_WorkStealingPool
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:20
 * @Version 1.0
 */
public class T11_WorkStealingPool {

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        // 由于产生的是 精灵线程(守护线程，后台线程) ， 主线程不阻塞的话，看不到输出
        System.in.read();
    }

    static class R implements Runnable {

        int time;

        public R(int i) {
            this.time = i;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(time + "  " + Thread.currentThread().getState());
        }
    }
}
