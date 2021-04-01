package com.zero.strategy;

/**
 * @ClassName StrategyImpl2
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 21:29
 * @Version 1.0
 */
public class StrategyImpl2 implements IStrategy{

    @Override
    public int calcThisNumber(int number) {
        return -number;
    }

    @Override
    public String addString(String string) {
        return string + "222";
    }
}
