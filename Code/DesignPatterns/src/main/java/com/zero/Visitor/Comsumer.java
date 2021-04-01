package com.zero.Visitor;

/**
 * @ClassName Comsumer
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:52
 * @Version 1.0
 */
public class Comsumer implements Visitor {

    @Override
    public void visit(Compute compute) {
        // 整体最终再打上九折
        System.out.println("now you price is " + compute.getPrice() * 0.9 );
    }

    @Override
    public void visitCpu(CPU cpu) {
        System.out.println(cpu.getPrice() * 0.95);
    }

    @Override
    public void visitMemory(Memory memory) {
        System.out.println(memory.getPrice() * 0.95);
    }

    @Override
    public void visitKeyBroad(KeyBorad keyBorad) {
        System.out.println(keyBorad.getPrice() * 0.95);
    }
}
