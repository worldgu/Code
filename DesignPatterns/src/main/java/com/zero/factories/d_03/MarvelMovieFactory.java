package com.zero.factories.d_03;

/**
 * 具体的工厂实现，确定当前组合内有哪些内容
 * 比如生产一个钢铁侠  和 他 对应的能力
 *
 * @ClassName MarvelMovieFactory
 * @Description TODO
 * @Author chunhaizhanng
 * @Date 2020/11/23 0:48
 * @Version 1.0
 */
public class MarvelMovieFactory extends BaseMovieFactory {

    @Override
    Hero getHero() {
        return new IronMan();
    }

    @Override
    SuperPower getSuperPower() {
        return new IronManSuperPower();
    }

    @Override
    Wicked getWicked() {
        return new Clown();
    }
}
