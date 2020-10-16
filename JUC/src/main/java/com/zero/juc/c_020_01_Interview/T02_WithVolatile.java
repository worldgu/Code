package com.zero.juc.c_020_01_Interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T02_WithVolatile
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 17:59
 * @Version 1.0
 */
public class T02_WithVolatile {

    // 添加volatile ,  使 t2 能够得到通知
    // volatile List lists = new LinkedList();
    volatile List lists = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T02_WithVolatile c = new T02_WithVolatile();

        new Thread(()->{
           for (int i = 0; i < 10; i++) {
               c.add(new Object());
               System.out.println("add " + i);
           }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            while(true){
                if(c.size() == 5){
                    break;
                }
            }
            System.out.println("t2 结束");
        },"t2").start();
    }
}
