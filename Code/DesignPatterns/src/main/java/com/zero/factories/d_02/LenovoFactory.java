package com.zero.factories.d_02;

import com.zero.factories.d_02.LenovoCompute;

/**
 * @ClassName LenovoFactory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:40
 * @Version 1.0
 */
public class LenovoFactory extends BaseComputeFactory{

    @Override
    public BaseCompute createCompute() {
        return new LenovoCompute();
    }

}
