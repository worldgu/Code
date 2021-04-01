package com.zero.juc.c_021_01_interview;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyContainer1
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 20:10
 * @Version 1.0
 */
public class MyContainer2<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; // 最多10个元素
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();


    public synchronized void put (T t) {
        lock.lock();

        try {
            while(lists.size() == MAX){
                producer.await();
            }

            lists.add(t);
            ++count;
            consumer.signal(); // 通知消费者线程进行消费

        } catch (InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }



        /* 前面的写法进行对比 */
//        while (lists.size() == MAX ) { // 想象为什么用while而不是时用if
//            try {
//                this.wait();  // effective java
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        lists.add(t);
//        ++count;
//        this.notifyAll();
    }

    public /*synchronized*/ T get() {
        T t = null;
        lock.lock();
        try {

            while(lists.size() == 0) {
                consumer.await();
            }

            t = lists.removeFirst();
            count --;
            consumer.signalAll();   //  通知生产者进行生产
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return t;

        /*  此为前面的写法 */
        /*T t = null;
        while(lists.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = lists.removeFirst();
        count --;
        this.notifyAll();
        return t;*/
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();

        // 启动消费者线程
        for (int i= 0;  i <10; i++) {
            new Thread(()->{
                for(int j = 0;j<5;j++) {System.out.println(c.get());}
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动生产者线程
        for (int i= 0;  i <2; i++) {
            new Thread(()->{
                for(int j = 0;j<25;j++) {
                    c.put(Thread.currentThread().getName() + "  " + j);
                }
            },"p"+i).start();
        }
    }
}
