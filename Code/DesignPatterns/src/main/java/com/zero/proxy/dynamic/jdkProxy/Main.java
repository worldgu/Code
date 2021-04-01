package com.zero.proxy.dynamic.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:41
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Man man = new Man();

        Human proxyInstance = (Human) Proxy.newProxyInstance(
                Human.class.getClassLoader(),
                new Class[]{Human.class},
                new HumanInvocationHandler(man));

        proxyInstance.run();
    }
}
