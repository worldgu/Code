package com.zero.circle;

/**
 *@ClassName Circle
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 15:32 
 *@Version 1.0 */
public class Circle {

    //私有属性-0.5分
    private double radius;   //成员变量--圆半径
    //两个构造方法
    Circle(){                //构造方法
        radius=0.0;
    }
    Circle(double r){        //构造方法
        radius=r;
    }
    // 方法定义及返回值正确
    double getPerimeter(){   //成员方法--求圆周长
        return 2*Math.PI*radius;
    }
    // 方法定义及返回值正确
    double getArea(){         //成员方法--求圆面积
        return Math.PI*radius*radius;
    }
    // 方法定义正确及方法调用正确
    void show(){              //成员方法--显示圆半径、周长、面积
        System.out.println("圆半径="+radius);
        System.out.println("圆周长="+getPerimeter());
        System.out.println("圆面积="+getArea());
    }

}
