package com.zero.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName T09_TransferQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 22:57
 * @Version 1.0
 */
public class T09_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");

//        strs.put("aas");
    }
}
