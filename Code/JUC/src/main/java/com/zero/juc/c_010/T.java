package com.zero.juc.c_010;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/21 20:16
 * @Version 1.0
 */
public class T {

    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }

}
class TT extends T {

    @Override
    synchronized void m (){
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
