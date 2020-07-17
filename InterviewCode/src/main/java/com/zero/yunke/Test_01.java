package com.zero.yunke;

/**
 *@ClassName Test_01
 *@Author 张春海
 *@Date 2020/7/17 22:03 
 *@Version 1.0 */

/****
 *
 *  ++i   :  先自增 1 ， 再对变量进行赋值
 *  i++   :  先对变量赋值，再  自增 1
 *
 *
 *
 *
 **/
public class Test_01 {

    public static void main(String[] args) {
        int k = 0;
        System.out.println(++k);
        System.out.println(k++);
        System.out.println(k);
        int ret = ++k + k++ + ++k + k++; // 4 1 8 2
        System.out.println(ret);
    }
}
