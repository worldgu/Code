package com.zero.circle;

/**
 *@ClassName Cylinder
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 15:33 
 *@Version 1.0 */
public class Cylinder extends Circle{

    //私有属性
    private double hight;                     //定义成员变量--圆柱高
    //构造方法定义及调用父类构造方法
    Cylinder(double r,double h) {            //构造方法
        super(r);
        hight=h;
    }
    //方法定义及返回值
    public  double getVolume(){              //成员方法--求圆柱体积
        return getArea()*hight;
    }
    // 方法定义正确及方法调用
    public void showVolume(){                //成员方法--显示圆柱体积
        System.out.println("圆柱体积="+getVolume());
    }

}
