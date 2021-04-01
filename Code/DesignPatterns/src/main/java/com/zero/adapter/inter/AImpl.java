package com.zero.adapter.inter;

/**
 * @ClassName AImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:25
 * @Version 1.0
 */
public class AImpl implements InterfaceA {

    @Override
    public String saySomething(String xxx) {
        return "1234" + xxx;
    }
}
