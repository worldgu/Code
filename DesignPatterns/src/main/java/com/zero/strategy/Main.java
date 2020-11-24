package com.zero.strategy;

/**
 *
 *                  策略模式   Strategy
 *  也是一种比较简明的设计模式，
 *
 *  主要思路是通过一个通用的接口定义某个行为，此行为的主要实现交由不同的策略实现类来进行实现，
 *
 *  而调用方只需要选择一个特定的策略进行接口调用，即可得到相应的策略的执行结果
 *
 *
 *  适用场景：不关心策略细节，且要求接口实现可以灵活替换
 *
 *
 *  Context: 策略的调用者，它明确一共有哪些策略可以使用
 * IStrategy:策略接口的定义，它明确策略的实现类可以实现哪些功能
 * StrategyImpl:每个具体的策略的实现者
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 21:30
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        int init = 100;
        // 使用策略一进行计算
        System.out.println(new StrategyImple1().calcThisNumber(init));
        // 使用策略二进行计算
        System.out.println(new StrategyImpl2().calcThisNumber(init));

        String string = "100";
        // 使用策略一进行计算
        System.out.println(new StrategyImple1().addString(string));
        // 使用策略二进行计算
        System.out.println(new StrategyImpl2().addString(string));


    }

}
