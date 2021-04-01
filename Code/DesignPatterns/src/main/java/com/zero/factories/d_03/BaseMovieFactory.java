package com.zero.factories.d_03;

/**
 * 抽象工厂定义，确定了产品组合，生产角色，并生产相应的超能力
 *
 * @ClassName BaseMovieFactory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 0:46
 * @Version 1.0
 */
public abstract class BaseMovieFactory {

    abstract Hero getHero () ;

    abstract SuperPower getSuperPower();

    abstract Wicked getWicked();
}
