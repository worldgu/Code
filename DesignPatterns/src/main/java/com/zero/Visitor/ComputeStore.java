package com.zero.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *          电脑商店，里面存储了 一组组好的元素集合
 *
 * @ClassName ComputeStore
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:49
 * @Version 1.0
 */
public class ComputeStore {

    private List<Compute> computes = new ArrayList<>();

    public ComputeStore () {
        computes.add(new Compute( new CPU(100), new Memory(100), new KeyBorad(100)));
        computes.add(new Compute( new CPU(200), new Memory(200), new KeyBorad(200)));
        computes.add(new Compute( new CPU(300), new Memory(300), new KeyBorad(300)));
    }

    public void sell (Visitor visitor) {
        for ( Compute compute : computes) {
            compute.accpt(visitor);
        }
    }
}
