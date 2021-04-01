package com.zero.Visitor;


/**
 * @ClassName Memory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:30
 * @Version 1.0
 */
public class Memory extends ComputePart {

    public Memory(int price) {
        super(price);
    }

    @Override
    public void accpt(Visitor visitor) {
        visitor.visitMemory(this);
    }
}
