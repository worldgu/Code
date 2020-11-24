package com.zero.Visitor;


/**
 * @ClassName KeyBorad
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:31
 * @Version 1.0
 */
public class KeyBorad extends ComputePart{

    public KeyBorad(int price) {
        super(price);
    }

    @Override
    public void accpt(Visitor visitor) {
        visitor.visitKeyBroad(this);
    }
}
