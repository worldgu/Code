package com.zero.Decorator;

/**
 * 发射子弹装饰器
 *
 * @ClassName FireDecorator
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:34
 * @Version 1.0
 */
public class FireDecorator extends BaseIronManSuit {

    private BaseIronManSuit suit;

    public FireDecorator (BaseIronManSuit suit) {
        this.suit = suit;
    }

    @Override
    protected void showFunction() {
        suit.showFunction();
        System.out.println(" fire add  new function , now you can  shoot enemies! ");
    }
}
