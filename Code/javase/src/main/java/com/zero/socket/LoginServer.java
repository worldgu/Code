package com.zero.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@ClassName LoginServer
 *@Description 使用TCP 网络编程完成用户登录功能
 *@Author 张春海
 *@Date 2020/6/13 23:35 
 *@Version 1.0 */
public class LoginServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //  1.创建一个ServerSocket，执行等待端口
        ServerSocket serverSocket = new ServerSocket(8888);
        //  2.使用ServerSocket 接收用户请求
        Socket socket = serverSocket.accept();
        //  3.创建输入流和输出流
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        //  4.接受用户数据并输出
        User user = (User) objectInputStream.readObject();
        System.out.println("我是服务器，接受到的信息是: " + user);
        //  5.发送反馈信息
        boolean flag = false;
        if ("zero".equals(user.getUsername())
                && "zero".equals(user.getPassword())) {
            flag = true;
        }
        dataOutputStream.writeBoolean(flag);
        // 6.关闭流和socket
        objectInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
