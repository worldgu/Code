package com.zero.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BranchNode
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:55
 * @Version 1.0
 */
public class BranchNode extends AbstractTreeNode {

    public BranchNode(String name) {
        super(name);
    }

    private List<AbstractTreeNode> children = new ArrayList<>();

    public List<AbstractTreeNode> getChildren () {
        return children;
    }

    public void setChildren ( List<AbstractTreeNode> children ) {
        this.children = children;
    }
}
