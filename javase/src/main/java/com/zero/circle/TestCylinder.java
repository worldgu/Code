package com.zero.circle;

/**
 *@ClassName TestCylinder
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 15:35 
 *@Version 1.0 */
public class TestCylinder {

    public static void main(String[] args) {
        //创建圆类对象正确及调用方法
        Circle ci=new Circle(10.0);             //生成圆类实例
        ci.show();                              //调用圆类的方法
        //创建圆类对象正确及调用方法正确1分
        Cylinder cyl=new Cylinder(5.0, 10.0);   //生成圆柱类实例
        cyl.show();                             //调用父类的方法
        cyl.showVolume();
    }
}
