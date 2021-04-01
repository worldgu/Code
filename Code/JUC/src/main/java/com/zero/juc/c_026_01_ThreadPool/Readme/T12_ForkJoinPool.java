package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName T12_ForkJoinPool
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 19:21
 * @Version 1.0
 */
public class T12_ForkJoinPool {

    static int[] nums = new int[100_0000];
    static final int MAX_NUM = 5_0000;
    static Random r = new Random();
    
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }

        System.out.println("---" + Arrays.stream(nums).sum()); // stream api
    }

    static class AddTask extends RecursiveAction {

        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from: " + start + " to:" + end + " = " + sum);

            } else {

                int middle = start + (end-start)/2;

                AddTask subTask1 = new AddTask(start,end);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();

            }

        }
    }

    static class AddTaskRet extends RecursiveTask<Long> {

        private static final long serialVersionUID = 1L;

        int start, end;

        public AddTaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            }

            int middle = start + (end-start)/2;

            AddTaskRet subTask1 = new AddTaskRet(start,end);
            AddTaskRet subTask2 = new AddTaskRet(middle, end);
            subTask1.fork();
            subTask2.fork();

            return subTask1.join() + subTask2.join();
        }
    }

    public static void main(String[] args) throws IOException {
        /*ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        fjp.execute(task);*/ // ---49512631

        T12_ForkJoinPool temp = new T12_ForkJoinPool();

        ForkJoinPool fjp = new ForkJoinPool();
        AddTaskRet task = new AddTaskRet(0,nums.length);

        fjp.execute(task);

        long result = task.join();
        System.out.println(result);  // ---49542833

        System.in.read();
    }
}
