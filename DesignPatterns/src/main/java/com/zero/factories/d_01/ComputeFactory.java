package com.zero.factories.d_01;

/**
 * 电脑生产的简单工厂
 * @ClassName ComputeFactory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:27
 * @Version 1.0
 */
public class ComputeFactory {

    public BaseCompute buyAppleCompute() {
        return new AppleCompute();
    }

    public BaseCompute buyLenovoCompute() {
        return new LenovoCompute();
    }
}
