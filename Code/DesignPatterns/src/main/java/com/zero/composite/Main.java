package com.zero.composite;

import java.util.ArrayList;

/**
 *
 *          组合模式 Composite
 *
 * 使用场景比较在限，最主要的作用在于描述树形结构
 *
 * 不是特别重要，不做太多篇幅
 *
 * 组合模式测试代码
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:57
 * @Version 1.0
 *
 */
public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");

        // 组装第一层节点
        LeafNode leaf1 = new LeafNode("leaf1");
        BranchNode branch1 = new BranchNode("branch1");
        BranchNode branch2 = new BranchNode("branch2");
        root.setChildren(new ArrayList<AbstractTreeNode>() {{
            add(leaf1);
            add(branch1);
            add(branch2);
        }});

        // 组装第二层节点
        LeafNode leaf11 = new LeafNode("leaf11");
        BranchNode branch12 = new BranchNode("branch12");
        BranchNode branch13 = new BranchNode("branch13");
        root.setChildren(new ArrayList<AbstractTreeNode>() {{
            add(leaf11);
            add(branch12);
            add(branch13);
        }});

        LeafNode leaf21 = new LeafNode("leaf21");
        LeafNode leaf22 = new LeafNode("leaf22");
        BranchNode branch23 = new BranchNode("branch23");
        root.setChildren(new ArrayList<AbstractTreeNode>() {{
            add(leaf21);
            add(leaf22);
            add(branch23);
        }});

        // 第三层
        LeafNode leaf231 = new LeafNode("leaf232");
        branch23.setChildren(new ArrayList<AbstractTreeNode>(){{
            add(leaf231);
        }});

        print(root,2);



    }

    private static void print (AbstractTreeNode root , int depth){
        for (int i = 0; i < depth; i++) {
            System.out.print(" -- ");
        }

        root.print();

        if ( root instanceof BranchNode) {
            BranchNode branchNode = (BranchNode) root;
            for  ( AbstractTreeNode child : branchNode.getChildren()) {
                print(child, depth + 1 );
            }
        }
    }
}
