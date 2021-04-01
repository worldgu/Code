package com.zero.socket;/**
 * Created by 张春海 on 2020/6/13  23:47
 */

import com.zero.socket.User;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *@ClassName LoginClient
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/13 23:47 
 *@Version 1.0 */
public class LoginClient {

    public static void main(String[] args) throws IOException {
        // 1.创建Socket , 用来发送请求
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        // 2.创建输入流和输出流
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        // 3.发送数据
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入用户名");String password = input.nextLine();
        User user = new User(username, password);
        oos.writeObject(user);
        // 4.接收反馈信息并输出
        boolean flag = dis.readBoolean();
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        // 5.关闭流和socket
        dis.close();		oos.close();		socket.close();

    }
}
