package com.zero.juc.c_027_future_to_loom;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @ClassName T02_ListenableFuture
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:55
 * @Version 1.0
 */
public class T02_ListenableFuture {
    public static void main(String[] args) {
        ListeningExecutorService service =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));
        ListenableFuture<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 8;
            }
        });

        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        },service);

        service.shutdown();
    }
}
