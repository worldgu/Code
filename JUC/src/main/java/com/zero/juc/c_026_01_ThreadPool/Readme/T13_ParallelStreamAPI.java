package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName T13_ParallelStreamAPI
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:44
 * @Version 1.0
 */
public class T13_ParallelStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 10000; i++) {
            nums.add(100_0000 + r.nextInt(100_0000));
        }

//        System.out.println(nums);

        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();

        System.out.println(end - start);  // 4209


        // 使用 parallel stream api

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(T13_ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();

        System.out.println(end - start);  //   2006
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0 ) return false;
        }
        return true;
    }
}
