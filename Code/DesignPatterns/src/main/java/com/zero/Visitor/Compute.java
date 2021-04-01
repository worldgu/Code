package com.zero.Visitor;


/**
 * 对于电脑的抽象， 假设里面的原件就三个且固定不变
 *
 * @ClassName Compute
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:29
 * @Version 1.0
 */
public class Compute extends ComputePart {

    private CPU cpu;

    private Memory memory;

    private KeyBorad keyBroad;

    public Compute(CPU cpu, Memory memory, KeyBorad keyBroad) {
        super(cpu.getPrice() + memory.getPrice() + keyBroad.getPrice());
        this.cpu = cpu;
        this.memory = memory;
        this.keyBroad = keyBroad;
    }

    @Override
    public void accpt(Visitor visitor) {
        visitor.visit(this);
    }
}
