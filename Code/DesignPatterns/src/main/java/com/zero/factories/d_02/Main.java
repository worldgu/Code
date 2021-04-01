package com.zero.factories.d_02;

/**
 *
 * 简单工厂，实现简单，扩展性差
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:29
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        BaseComputeFactory factory = new AppleFactory();
        factory.createCompute().print();
    }
}
