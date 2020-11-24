package com.zero.proxy.dynamic.cg;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName ManInterceptor
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:44
 * @Version 1.0
 */
public class ManInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始热身");
        // 调用了被代理对象的真实业务，在方法面前进行增强处理
        Object invoke = proxy.invoke(obj,args);
        System.out.println("开始拉伸");
        return invoke;
    }
}
