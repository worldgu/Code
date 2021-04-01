package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName T09_FixedThreadPool
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 18:03
 * @Version 1.0
 */
public class T09_FixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start,end;
        start = System.currentTimeMillis();

        getPrime(1, 20_0000);
        end = System.currentTimeMillis();
        System.out.println(end - start);  //   10278

        final int cpuCoreNum = 4;

        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1 , 80000); // 1-5  5-10  10-15  15-20
        MyTask t2 = new MyTask(80001 , 13_0000);
        MyTask t3 = new MyTask(12_0001 , 17_0000);
        MyTask t4 = new MyTask(17_0001 , 20_0000);

        Future<List<Integer>> f1 =service.submit(t1);
        Future<List<Integer>> f2 =service.submit(t2);
        Future<List<Integer>> f3 =service.submit(t3);
        Future<List<Integer>> f4 =service.submit(t4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();

        end = System.currentTimeMillis();
        System.out.println(end - start);  // 3065



    }

    static class MyTask implements Callable<List<Integer>> {

        int startPos, endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos,endPos);
            return null;
        }
    }

    static boolean isPrime( int num ) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    static List<Integer> getPrime(int start , int end){
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end ; i++) {
            if ( isPrime(i)) {
                results.add(i);
            }
        }
        return results;
    }
}
