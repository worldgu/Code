package com.zero.main;

import lombok.extern.java.Log;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 *@ClassName Test
 *@Description
 *@Author 张春海
 *@Date 2020/6/12 10:56 
 *@Version 1.0 */
@Log
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
        Integer as = new Integer("666");  //  其中有一个格式转换
//        System.out.println(">>>>>> " + as);

        //
        assert  1>0;

    }

    static void mb_operate(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
    }


    @Test
    public void TestCalendar(){
        Calendar as = Calendar.getInstance();
        System.out.println(">>>>" + as.getTimeZone());
        System.out.println(">>>>" + as.getTimeZone());
        System.out.println(">>>>" + as.getTimeZone());
    }

    @Test
    public void TestString(){
        String s = "story";
//        char c = s[1];
        int lent = s.length();
//        String t = 100;
        System.out.println(">>>>" + (s+="books"));
    }

    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    @Test
    public void TestExcample() {
        DemoTest ex = new DemoTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + "and");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    @Test
    public void TestFile(){
        String str ="文件写入练习";
        FileWriter fw = null;        //1
        try{
            fw = new FileWriter("c:mytext.txt");  //2
//            fw.writerToEnd(str);   //3
        }catch(IOException e){   //4
            e.printStackTrace();
        }finally{
            //此处省略关闭流
        }
    }

    @Test
    public void TestShuZu(){
        int[][] t={{1,2,3},{4,5,6}};
        System.out.print( t.length + ">>>>>>>>" + t[0].length);

    }
}
