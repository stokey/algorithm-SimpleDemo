package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;
import com.stokey.algorithmdemo.Algorithm.model.GraphModal;

import java.util.LinkedList;

/**
 * Created by tiangen on 2017/5/25.
 */

public class D23PrintFromTopToBottom {
    /**
     * 从上往下打印二叉树
     * 二叉树的层序遍历
     *
     * @param root
     */
    public static void printV(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
        list.add(root);

        while (!list.isEmpty()) {
            BinaryTreeNode node = list.poll();
            System.out.println("Value:" + node.getValue());

            if (node.getLeftNode() != null) {
                list.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                list.add(node.getRightNode());
            }
        }
    }

    /**
     * 广度优先遍历一个有向图
     * TODO 通过队列实现
     * @param modal
     */
    public static void printG(GraphModal modal) {

    }
}

class D23Test {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> leftLeafNode = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rightLeafNode = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(2, leftLeafNode, rightLeafNode);

        D23PrintFromTopToBottom.printV(root1);
    }
}