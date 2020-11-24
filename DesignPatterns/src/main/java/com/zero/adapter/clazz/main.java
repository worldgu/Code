package com.zero.adapter.clazz;

/**
 * @ClassName main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:37
 * @Version 1.0
 */
public class main {

    public static void main(String[] args) {
        AImpl a = new AImpl(new Person());
        a.saySomething("ss");
    }
}
