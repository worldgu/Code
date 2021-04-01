package com.zero.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *@ClassName StringCliient
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 16:23 
 *@Version 1.0 */
public class StringCliient {

    Socket socket;            //声明Socket对象
    BufferedReader in;        //声明输入流对象
    PrintWriter out;          //声明输出流对象
    public StringCliient(){          //构造方法
        //异常处理0.25分
        try {
            //创建Socket对象，用来发送请求0.5分
            socket=new Socket("127.0.0.1", 10000);
            //创建字符缓冲区对象0.5分
            BufferedReader line=new BufferedReader(new InputStreamReader(System.in));
            //创建输出流对象并输出0.5分
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println(line.readLine());
            //创建输入流对象0.5分
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            //关闭流对象0.5分
            out.close();
            in.close();
        } catch (Exception e) {
            System.out.println("出错了!");
        }
    }
    public static void main(String[] args) {
        //创建对象0.25分
        new StringCliient();
    }
}
