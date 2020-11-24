package com.zero.factories.d_02;

/**
 * @ClassName LenovoCompute
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:26
 * @Version 1.0
 */
public class LenovoComputeFactory extends BaseComputeFactory {

    @Override
    public BaseCompute createCompute() {
        return new LenovoCompute();
    }
}
