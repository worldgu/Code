package com.zero.thread;

/**
 *@ClassName ThreadTest
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 15:58
 *@Version 1.0 */
/**
 * 设计4个线程
 * 其中两个线程每次对J增加1
 * 另外连个线程对 j 每次减少 1
 *
 *
 *
 **/
public class ThreadTest {

    private int j ;

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Inc inc=tt.new Inc();                //创建内部线程类对象
        Dec dec=tt.new Dec();                //创建内部线程类对象
        for(int i=0;i<2;i++){
            // 创建线程对象
            Thread t=new Thread(inc);
            t.start();
            // 创建线程对象
            t=new Thread(dec);
            t.start();
        }
    }

    //  实现同步对 j 的增加
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }

    //  实现同步对 j 的值减
    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }

    //内部类
    //内部类定义正确并实现run方法1分
    class Inc implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <100; i++) {
                inc();                      //调用加的方法
            }
        }
    }
    //内部类定义正确并实现run 方法1分
    class Dec implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <100; i++) {
                dec();                         //调用减的方法
            }
        }
    }
}
