package com.zero.yunke;/**
 * Created by 张春海 on 2020/7/17  22:11
 */

/**
 *@ClassName Test_02
 *@Description TODO
 *@Author 张春海
 *@Date 2020/7/17 22:11 
 *@Version 1.0 */
public class Test_02 {

    public static void main(String[] args) {
        int i =1;
        Integer a = 200;
        Integer b = 200;

        System.out.println(a==b);   //TODO:  TRUE

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        System.out.println(str1==str2);    //  true
        System.out.println(str1==str3);    //  false

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println(sb1==sb2);       //  false
        System.out.println(sb1.equals(sb2));  // TODO: true

        System.out.println(str1.equals(sb1));  // TODO: true

        /**
         * 运行结果
         * false
         * true
         * false
         * false
         * false
         * false
         **/
    }
}
