package com.zero.Decorator;

/**
 * @ClassName LaserDecorator
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:36
 * @Version 1.0
 */
public class LaserDecorator extends BaseIronManSuit {

    private BaseIronManSuit suit;

    public LaserDecorator(BaseIronManSuit suit) {
        this.suit = suit;
    }

    @Override
    protected void showFunction() {
        suit.showFunction();
        System.out.println("add new function ! now you can shots lasers ");
    }
}
