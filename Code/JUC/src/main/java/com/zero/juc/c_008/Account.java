package com.zero.juc.c_008;

import java.sql.Time;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Account
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 20:02
 * @Version 1.0
 */
public class Account {

    String name;
    double balance;

    public synchronized void  set(String name, double balance){
        this.name = name;

        try {
            Thread.sleep(2000);   //  模拟高并发时的 事务未完成时的情况
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public /*synchronized*/ double  getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();

        new Thread(()->a.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));



    }
}
