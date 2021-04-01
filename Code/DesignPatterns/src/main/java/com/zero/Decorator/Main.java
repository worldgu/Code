package com.zero.Decorator;

/**
 *          装饰器模式  Decorator
 *
 * 对一个类进行不断的装饰，不断的去丰富类的功能，又保证不改动原来的类，
 *
 * 即在原来类的基础上，动态的扩展新的功能，这个点听起来与代理模式非常像，
 *
 * 但代理模式更加侧重于对类增强部分的处理，即这个类被我代理后，我应该怎样去增强它？
 *
 * 装饰器模式则是我有一组已经实现好的增强，这次需要给这个类增加哪一个或者哪几个增强呢？
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:39
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // 在不改动mark1 战甲 的基础上给他加上开枪与发射激光的能力
        BaseIronManSuit newSuit = new LaserDecorator(new FireDecorator(new Mark1()));

        newSuit.showFunction();

    }
}
