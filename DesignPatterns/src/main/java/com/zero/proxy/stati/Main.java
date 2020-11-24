package com.zero.proxy.stati;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:31
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Human man = new Man();
        // 静态代理测试
        HumanProxy proxy = new HumanProxy(man);

        proxy.run();
    }
}
