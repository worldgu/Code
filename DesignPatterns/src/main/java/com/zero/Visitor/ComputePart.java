package com.zero.Visitor;


/**
 * 对元器件做一次抽象
 *
 * @ClassName ComputePart
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:29
 * @Version 1.0
 */
public abstract class ComputePart {

    private int price;

    public ComputePart (int price) {
        this.price = price;
    }

    public int getPrice (){
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public abstract void accpt (Visitor visitor);
}
