package com.zero.juc.c_012_Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName T04_VolatileNotSync
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 17:16
 * @Version 1.0
 */
public class T04_VolatileNotSync {
      volatile int count = 0;
      void m () {
          for (int i=0; i<10_000; i++ ) {
              count ++;
          }
      }

    public static void main(String[] args) {
        T04_VolatileNotSync t = new T04_VolatileNotSync();

        List<Thread> threads = new ArrayList<Thread>();

        for ( int i = 0 ; i < 10 ; i++) {
            threads.add(new Thread(t::m,"thread-" + i));
        }

        // 启动线程
        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
