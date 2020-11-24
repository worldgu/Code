package com.zero.factories.d_03;

/**
 * 具体的工厂实现，确定当前组合内有哪些内容
 *
 * @ClassName DCMovieFactory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:53
 * @Version 1.0
 */
public class DCMovieFactory extends BaseMovieFactory {
    @Override
    Hero getHero() {
        return new SuperMan();
    }

    @Override
    SuperPower getSuperPower() {
        return new SuperManSuperPower();
    }

    @Override
    Wicked getWicked() {
        return new Clown();
    }
}
