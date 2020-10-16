package com.zero.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName T08_SynchronusQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 22:54
 * @Version 1.0
 */
public class T08_SynchronusQueue {  // 容量为零

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //  等待消费者进行消费
//        strs.put("bbb");
//        strs.add("aaa"); // 容量为零 直接添加报错
        System.out.println(strs.size());
    }

}
