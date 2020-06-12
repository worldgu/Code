package com.zero.main;

import org.junit.Test;

/**
 *@ClassName Test
 *@Description
 *@Author 张春海
 *@Date 2020/6/12 10:56 
 *@Version 1.0 */
public class DemoTest {

    @Test
    public void TestBoolean(){
//        boolean m = true;
//        if (m = false) {
//            System.out.println("false");
//        } else {
//            System.out.println("true");
//        }


//        Integer C = 0;
//        ++C;
//
//        System.out.println(">>>>" + C);
//
//        C++;
//
//        System.out.println(">>>>" + C);

        //  线程安全的使用Synchronized  效率较低   synchronized
//        StringBuffer sb = new StringBuffer();
//
//        // 线程不安全  非高并发的情况下使用  效率高
//        StringBuilder sd = new StringBuilder();

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        mb_operate(a, b);
        System.out.println(a + "." + b);

//        float []f[] = new float[6][6];
////        float fa[][] = new float[][];
////        float [6][]fs = new float[6][6];
//        float [][]fss = new float[6][];
int ab = 1;
        Integer as = new Integer("asda");  //  其中有一个格式转换
//        System.out.println(">>>>>> " + as);

        //
        assert  1>0;

    }

    static void mb_operate(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
    }
}
