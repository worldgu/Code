package com.zero.zhongke;
/**
 *@ClassName add_01
 *@Description TODO
 *@Author 张春海
 *@Date 2020/7/17 21:11 
 *@Version 1.0 */
public class add_01 {

    public static void main(String[] args) {

        for ( int i =9;i > 0 ; i--) {
            System.out.println(" ");
            for (int j=i;j>0;j--) {
                System.out.print(i + "*" + j + "=" +(i*j) +" ");
            }
        }
    }

    public void modify() {
        int i,j,k;
        i =100;

        while( i > 0 ){
            j = i * 2;
            System.out.println("this value of j is " + j);
//            k = k + 1 ;  // TODO:  k为进行初始化
            i--;
        }
    }
}
