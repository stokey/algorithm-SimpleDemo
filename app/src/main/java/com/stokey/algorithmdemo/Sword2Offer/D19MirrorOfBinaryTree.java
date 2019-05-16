package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;

/**
 * Created by stokey on 2017/5/23.
 */

public class D19MirrorOfBinaryTree {
    /**
     * 二叉树的镜像（左节点变右节点，右节点变成左节点）
     * @param head
     * @return
     */
    public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.getLeftNode() == null && head.getRightNode() == null) {
            return head;
        }
        BinaryTreeNode<Integer> temp = head.getLeftNode();
        head.setLeftNode(head.getRightNode());
        head.setRightNode(temp);
        if (head.getLeftNode() != null) {
            mirror(head.getLeftNode());
        }
        if (head.getRightNode() != null) {
            mirror(head.getRightNode());
        }
        return head;
    }
}

class D19Test {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> leftLeafNode = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rightLeafNode = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(2, leftLeafNode, rightLeafNode);

        root1.printPre();
        System.out.println("\n===================");
        D19MirrorOfBinaryTree.mirror(root1).printPre();
    }
}

