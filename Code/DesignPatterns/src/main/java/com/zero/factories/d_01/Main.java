package com.zero.factories.d_01;

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
        BaseCompute apple = new ComputeFactory().buyAppleCompute();
        BaseCompute lenovoCompute = new ComputeFactory().buyLenovoCompute();
    }
}
