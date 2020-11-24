package com.zero.adapter.inter;

/**
 *
 * 适配器
 *
 * @ClassName Adapter
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:27
 * @Version 1.0
 */
public class Adapter extends AImpl implements InterfaceB {

    @Override
    public Long printLong(Long number) {
        // 适配过程
        return number + Long.parseLong(saySomething("5555"));
    }
}
