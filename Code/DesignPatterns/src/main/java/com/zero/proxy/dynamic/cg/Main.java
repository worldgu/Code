package com.zero.proxy.dynamic.cg;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 13:19
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类位Man
        // 所以final类型的类没有子类，就无法通过cglib处理
        enhancer.setSuperclass(Man.class);
        // 设置代理的回调函数
        enhancer.setCallback(new ManInterceptor());
        //  创建初Man类的代理子类
        Man man = (Man)enhancer.create();

        man.run();
    }
}
