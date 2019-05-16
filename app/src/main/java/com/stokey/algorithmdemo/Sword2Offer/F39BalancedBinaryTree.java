package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;

/**
 * Created by stokey on 2017/6/4.
 */

public class F39BalancedBinaryTree {
    /**
     * 获取一棵树的深度
     *
     * @param root
     * @return
     */
    public static int deep(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.getLeftNode());
        int right = deep(root.getRightNode());
        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 判断一棵树是否是平衡二叉树
     * 【根据深度差求法：效率不高，同个节点会被多次遍历】
     *
     * @param root
     * @return
     */
    public static boolean isBalanceTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        int left = deep(root.getLeftNode());
        int right = deep(root.getRightNode());
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanceTree(root.getLeftNode()) && isBalanceTree(root.getRightNode());
    }

    /**
     * 判断一棵树是否是平衡二叉树
     * 【根据后续遍历方式：能保证每个节点只被遍历一次】
     *
     * @param root
     * @return
     */
    public static boolean isBalanceTreeAdvance(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        Integer deep = 0;
        return isAdvance(root, deep);
    }

    private static boolean isAdvance(BinaryTreeNode root, Integer deep) {
        if (root == null) {
            deep = 0;
            return true;
        }
        Integer left = 0;
        Integer right = 0;
        if (isAdvance(root.getLeftNode(), left) && isAdvance(root.getRightNode(), right)) {
            int diff = Math.abs(left - right);
            if (diff <= 1) {
                deep = 1 + Math.max(left, right);
                return true;
            }
        }
        return false;
    }
}
