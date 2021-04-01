package com.zero.strategy;

/**
 * @ClassName StrategyImple1
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 21:28
 * @Version 1.0
 */
public class StrategyImple1 implements IStrategy{

    @Override
    public int calcThisNumber(int number) {
        return number + 3;
    }

    @Override
    public String addString(String string) {
        return string + "1111";
    }
}
