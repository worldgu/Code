package com.zero.juc.c_026_00_interview.A1B1C3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T10_00_PipedStream
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 23:52
 * @Version 1.0
 */
public class T10_00_PipedStream {


    public static void main(String[] args) throws IOException {
        char[] aI = "ABCDEFG".toCharArray();
        char[] aC = "1234567".toCharArray();

        PipedInputStream input1 = new PipedInputStream();
        PipedInputStream input2 = new PipedInputStream();

        PipedOutputStream output1 = new PipedOutputStream();
        PipedOutputStream output2 = new PipedOutputStream();

        input1.connect(output2);
        input2.connect(output1);

        String msg = "Your Turn";

        new Thread(()->{

            byte[] buffer = new byte[9];

            try {
                for (char c : aI) {
                    input1.read(buffer);   // 第一次是  t2 写消息，t1读取消息 讲读取的消息转换为 字符串  与 msg 中的内容进行比较
//                    System.out.println(new String(buffer));
                    if ( new String(buffer).equals(msg)) {
                        System.out.print(c);
                    }

                    output1.write(msg.getBytes());
                }
            } catch ( Exception ex) {
                ex.printStackTrace();
            }

        },"t1").start();

        new Thread(()->{

            byte[] buffer = new byte[9];

            try {
                for (char c : aC) {

                    System.out.print(c);

                    output2.write(msg.getBytes());
                    input2.read(buffer);


                    if ( new String(buffer).equals(msg)) {
                        continue;
                    }

                }
            } catch ( Exception ex) {
                ex.printStackTrace();
            }
        },"t2").start();
    }
}
