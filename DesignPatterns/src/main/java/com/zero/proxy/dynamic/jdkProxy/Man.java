package com.zero.proxy.dynamic.jdkProxy;


/**
 * 定义男性的实现并实现跑步接口
 *
 * @ClassName Man
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:27
 * @Version 1.0
 */
public class Man implements Human {

    @Override
    public void run() {
        System.out.println("开始跑步----------");
        System.out.println("结束跑步----------");
    }
}
