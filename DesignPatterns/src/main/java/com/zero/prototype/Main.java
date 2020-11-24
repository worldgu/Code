package com.zero.prototype;

/**
 *                原型模式
 *
 * 又是一种用法比较局限的设计模式，最典型的场景即为java的Cloneable接口，核心思想为提供一个快速创建重复对象的方式
 *
 * 可以快速的通过拷贝方式对现有对象完成快速复制
 *
 * 需要注意浅拷贝与深拷贝的问题
 *
 *  ==========  总结 ============
 *
 *  1.对于八大基础类型，是可以直接实现克隆
 * 2.对于String类型，因为有常量池的存在，看起来和基础类型表现一致，可以实现“深拷贝”
 * 3.对于对象类型，复制时会复制出同一个指针，指向同一个地址，因此指向的对象为同一个，这叫浅拷贝，因此在运用Cloneable接口时需要格外注意
 *
 * @ClassName Main
 * @Author 张春海
 * @Date 2020/11/23 15:13
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) throws Exception{


        //  基本数据类型测试
        Prototype prototype = new Prototype();

        Prototype prototype1 = (Prototype) prototype.clone();
        prototype1.setX(10);
        // 基础数据互不干扰
        System.out.println(prototype.getX());
        System.out.println(prototype1.getX());


        //  String 引用类型测试
        Prototype2 prototype2 = new Prototype2();

        Prototype2 prototype22 = (Prototype2) prototype2.clone();
        prototype22.setX("hello");
        // 看清来也互不干扰，实际是因为JAVA常量池导致的
        System.out.println(prototype2.getX());
        System.out.println(prototype22.getX());


        //  对象类型测试
        Prototype3 prototype3 = new Prototype3();

        Prototype3 prototype33 = (Prototype3) prototype3.clone();
        prototype33.setY(100);
        // 基础数据互不干扰，但是引用类型指向同一个地址
        System.out.println(prototype3.getY());
        System.out.println(prototype3.getObject());
        System.out.println(prototype33.getY());
        System.out.println(prototype33.getObject());


    }





}
