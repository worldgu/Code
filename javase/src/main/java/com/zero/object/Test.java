package com.zero.object;

/**
 *@ClassName Test
 *@Description TODO
 *@Author 张春海
 *@Date 2020/9/2 21:58 
 *@Version 1.0 */
public class Test {

    public static void main(String[] args) {

        UserEntity user = new UserEntity("zhangsan");
        System.out.println(" 1 >>>> " + user.toString());
        m2(user);
        System.out.println(" 2 >>>> " + user.toString());


    }


    public static void m2 ( UserEntity user) {
        user.username = "lisi";
    }
}
