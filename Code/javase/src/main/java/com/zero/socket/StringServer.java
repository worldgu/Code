package com.zero.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@ClassName StringServer
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 16:21 
 *@Version 1.0 */
public class StringServer {

    private ServerSocket ss;     //声明ServerSocket对象
    private Socket socket;       //声明Socket对象
    private BufferedReader in;   //声明输入流对象BufferedReader
    private PrintWriter out;     //声明输出流对象
    public StringServer(){
        //异常处理0.25分
        try {
            //创建一个ServerSocket，指定等待端口1分
            ss=new ServerSocket(10000);
            while(true){
                //使用ServerSocket接收用户请求（处于监听状态）1分
                socket=ss.accept();  //获得客户端的socket对象
                //创建输入流并读取信息0.5分
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line=in.readLine();
                System.out.println("客户端说:"+line);
                //创建输出流并输出信息0.5分
                out=new PrintWriter(socket.getOutputStream(),true);
                out.print("您的信息已接收!");
                //关闭流和socket0.5分
                out.close();
                in.close();
                socket.close();
            }

        } catch (IOException e) {
            out.println("出错了!");
        }  //创建ServerSocket对象

    }
    public static void main(String[] args) {//程序主入口
        //创建对象0.25分
        new StringServer();
    }
}
