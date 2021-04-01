package com.zero.juc.c_012_Volatile;

/**
 * @ClassName T03_VolatileReference2
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 16:23
 * @Version 1.0
 */
public class T03_VolatileReference2 {

    private static class Data {
        int a,b;

        public Data(int a,int b){
            this.a = a;
            this.b = b;
        }
    }

    volatile static Data data;

    /**
     *  开启两个线程， 一个写线程，一个线程
     *  当读线程 读入数字不一样时 打印输出
     *
     *  情况分析:  为什么x 不等于 y
     *
     *   首先一个对象，两个线程进行操作
     *      一个向里面写数据，总共  10000次
     *      一个读取里里面的数据
     *              数据不为空 则取值 进行判断 然后输出
     *              为什么 取值判断 不放在 while 中，
     *              因为 我们一定确认:
     *                          当data 不为空时， 进行取值操作，x 一定不等于 y
     *                          我们 为什么如此确认  因为 data 是 volatile 保证了线程间的可见性
     *                          值修改后  线程间可见(线程每次读取 都会到 堆中读取 x,y的值)
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
           for (int i = 0; i < 10000; i++) {
               data = new Data(i,i);
           }
        });

        Thread reader = new Thread(()->{
           while (data == null) {}

           int x = data.a;
           int y = data.b;
           if (x != y) {
               System.out.printf("a = %s , b = %s%n", x,y);
           }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");


    }
}
