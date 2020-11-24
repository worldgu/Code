package com.zero.bridge;

import org.apache.tools.ant.taskdefs.Sync;

/**
 *          桥接模式  Bridge
 *  将抽象部分与具体实现分开，通过聚合的方式代替继承，防止因为类不断继承产生类爆炸
 *
 * 比如手机有很多品牌，手机还可以安装游戏，游戏又有不同的开发厂商，将游戏进行抽象，聚合到手机类中，
 *
 * 可以通过安装游戏的方法，将不同的游戏对象装入手机对象中，获得不同的对象结果
 *
 * 整体上与抽象工厂非常相似，但侧重点不同，抽象工厂侧重于对于一组产品的集中式扩展，
 *
 * 而桥接模式是为了防止类的继承爆炸，是为了解决继承带来的强耦合而提出的设计模式
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 17:11
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Phone myPhone = new Huawei();

        System.out.println(myPhone.getName());
        myPhone.installGame(new WangZhe());
        myPhone.installGame(new YinYangShi());

        myPhone = new IPhone();
        System.out.println(myPhone.getName());
        myPhone.installGame(new WangZhe());
        myPhone.installGame(new YinYangShi());
        System.out.println(myPhone.getClass());


    }
}
