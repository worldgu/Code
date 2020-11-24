package com.zero.proxy.dynamic.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的逻辑增强实现
 *
 * @ClassName HumanInvocationHandler
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:37
 * @Version 1.0
 */
public class HumanInvocationHandler implements InvocationHandler {

    private Human human;

    public HumanInvocationHandler (Human human) {
        this.human = human;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始热身");
        // 调用了被代理对象的真实业务，在方法面前进行增强处理
        Object invoke  = method.invoke(human, args);
        System.out.println("开始拉伸");
        return invoke;
    }
}
