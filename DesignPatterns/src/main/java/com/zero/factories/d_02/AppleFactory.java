package com.zero.factories.d_02;

/**
 * @ClassName AppleCompute
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:26
 * @Version 1.0
 */
public class AppleFactory extends BaseComputeFactory {

    @Override
    public BaseCompute createCompute() {
        return new AppleCompute();
    }
}
