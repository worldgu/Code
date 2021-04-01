package com.zero.builder;

/**
 *
 * 对于一些属性较多的类，或者构造过程较复杂的类，通过建造者模式可以灵活定义哪些属性需要配置，哪些属性无需配置，同时屏蔽内部的创建逻辑。
 *
 * 通常的做法都是在内部添加一个内部类，通过内部类的方法添加各个属性并返回建造器自己的方式实现链式调用，最后可以在build()方法中实现复杂计算并返回构造好的对象
 *
 * 它和工厂模式的区别在于工厂模式并不关心产品的生产过程，只管找工厂要产品，而builder模式则可以对产品的生产过程进行定制
 *
 * 运用的比较典型的像mybatis 的xmlConfigBuilder xmlMapperBuilder XMLScriptBuilder等等
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 14:57
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Compute compute = new Compute.Builder().cpu("i10").memory("32G").display("34#").keyBroad("cherry").build();

        System.out.println(compute.toString());

    }
}
