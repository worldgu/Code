package com.zero.juc.c_025;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T06_ArrayBlockingQueue
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 22:13
 * @Version 1.0
 */
public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r =  new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

//        strs.put("aaa");  // 满了就会等待 ，程序阻塞
//        strs.add("aaa");  // 插不进去，报错
//        strs.offer("aaa"); // 插不进去，但是不报错
        strs.offer("aaa", 1, TimeUnit.SECONDS);  // 插不进去，但是可以设置等待时间，在等待时间内还插不进去就跳过

        System.out.println(strs);
    }
}
