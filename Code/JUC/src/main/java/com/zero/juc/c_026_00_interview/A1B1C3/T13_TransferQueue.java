package com.zero.juc.c_026_00_interview.A1B1C3;

import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @ClassName T08_00_lock_condition
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:37
 * @Version 1.0
 */
public class T13_TransferQueue {

    public static void main(String[] args) {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(()->{

            try {
                for (char c : aI) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                for (char c : aC) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
