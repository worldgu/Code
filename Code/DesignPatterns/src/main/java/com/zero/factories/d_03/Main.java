package com.zero.factories.d_03;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 1:02
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        BaseMovieFactory baseFactory = new DCMovieFactory();
        baseFactory.getHero().say();
        baseFactory.getSuperPower().show();

        System.out.println("=====>>>>>>>>");

        baseFactory = new MarvelMovieFactory();
        baseFactory.getHero().say();
        baseFactory.getSuperPower().show();

        System.out.println("=====>>>>>>>>");

        baseFactory = new DCMovieFactory();
        baseFactory.getWicked().Action();
        baseFactory.getWicked().Action();
        baseFactory.getWicked().Action();

    }
}
