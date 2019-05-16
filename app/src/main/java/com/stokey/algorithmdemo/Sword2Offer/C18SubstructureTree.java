package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;

/**
 * Created by stokey on 2017/5/23.
 */

public class C18SubstructureTree {
    /**
     * 输入两棵二叉树A和B
     * 判断B是不是A的子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        boolean result = false;
        if (root1.getValue() == root2.getValue()) {
            result = doesTree1HasTree2(root1, root2);
        }

        if (!result) {
            // 未找到匹配的树，从左子树开始重新遍历
            result = hasSubTree(root1.getLeftNode(), root2);
        }

        if (!result) {
            // 未找到匹配的树，从右子树开始重新遍历
            result = hasSubTree(root1.getLeftNode(), root2);
        }

        return result;
    }

    private static boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result;
        if (root1 != null && root2 != null) {
            if (root1.getValue() == root2.getValue()) {
                result = doesTree1HasTree2(root1.getLeftNode(), root2.getLeftNode());
                if (result) {
                    result = doesTree1HasTree2(root1.getRightNode(), root2.getRightNode());
                }
            } else {
                result = false;
            }
        } else if (root2 == null) {
            // root2遍历完成
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}

class C18Test {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> leftLeafNode = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rightLeafNode = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> temp1 = new BinaryTreeNode<Integer>(2, leftLeafNode, rightLeafNode);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> tempRootLeft = new BinaryTreeNode<Integer>(8, temp2, temp1);
        BinaryTreeNode<Integer> tempRootRight = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(8, tempRootLeft, tempRootRight);

        BinaryTreeNode<Integer> tempLeft = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> tempRight = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<Integer>(8, tempLeft, tempRight);

        BinaryTreeNode<Integer> tempLeft1 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> tempRight2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> root3 = new BinaryTreeNode<Integer>(8, tempLeft1, tempRight2);

        System.out.println("Tree1 has Tree2:" + C18SubstructureTree.hasSubTree(root1, root2));
        System.out.println("Tree1 has Tree3:" + C18SubstructureTree.hasSubTree(root1, root3));
    }
}
