package com.zero.juc.c_024_FromVectorToQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TicketSeller3
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:02
 * @Version 1.0
 */
public class TicketSeller3 {

    static List<String> tickets  = new LinkedList<>();

    static {
        for ( int i =0 ; i < 1000; i++) {
            tickets.add("票编号: " + i);
        }
    }

    public static void main(String[] args) {

        for ( int i = 0; i < 10 ; i++) {
            new Thread(()->{
                while (true) {
                    synchronized(tickets) {
                        if(tickets.size() <= 0) break;
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(" 销售了 ----  " + tickets.remove(0));

                    }
                }

            }).start();
        }
    }
}
