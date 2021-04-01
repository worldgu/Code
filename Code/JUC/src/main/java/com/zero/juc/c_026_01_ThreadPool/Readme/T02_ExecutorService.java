package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName T02_ExecutorService
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:15
 * @Version 1.0
 */
public class T02_ExecutorService {

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
    }
}
