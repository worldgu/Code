package com.zero.juc.c_017_MoreAboutSync;

/**
 * @ClassName DoNotLockString
 * @Description TODO
 * @Author 张春海
 * @Date 2020/9/24 22:34
 * @Version 1.0
 */
public class DoNotLockString {

    String s1 = "hello";
    String s2 = "hello";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){

        }
    }
}
