package com.zero.Visitor;

/**
 * @ClassName Visitor
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:44
 * @Version 1.0
 */
public interface Visitor {

    void visit (Compute compute);

    void visitCpu (CPU cpu);

    void visitMemory (Memory memory);

    void visitKeyBroad (KeyBorad keyBorad);
}
