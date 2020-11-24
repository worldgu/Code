package com.zero.composite;

import lombok.Data;

/**
 * 抽象父类
 *
 * @ClassName AbstractTreeNode
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:53
 * @Version 1.0
 */
@Data
public abstract  class AbstractTreeNode {

    protected String name;

    public AbstractTreeNode (String name) {
        this.name = name;
    }

    public void print () {
        System.out.println(this.name);
    }
}
