package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;

import java.util.Arrays;

/**
 * Created by stokey on 2017/5/21.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历中和中序遍历的结果中都不含重复的数字。
 */

public class B06ConstructBinaryTree {
    public static BinaryTreeNode construct(int[] preOrder, int[] midOrder) {
        BinaryTreeNode root = null;
        if (preOrder != null && midOrder != null
                && preOrder.length == midOrder.length && midOrder.length > 0) {
            int size = midOrder.length;
            int rootValue = preOrder[0];
            root = new BinaryTreeNode(rootValue);
            int i = 0;
            for (; i < size; i++) {
                if (rootValue == midOrder[i]) {
                    break;
                }
            }
            if (i > 0) {
                // 左子树
                root.leftNode = construct(Arrays.copyOfRange(preOrder, 1, i + 1),
                        Arrays.copyOfRange(midOrder, 0, i));
            }
            if (i + 1 < size) {
                // 右子树
                root.rightNode = construct(Arrays.copyOfRange(preOrder, i + 1, size), Arrays.copyOfRange(midOrder, i + 1, size));
            }
        }
        return root;
    }
}

class Test {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode node = B06ConstructBinaryTree.construct(pre, mid);
        node.printPre();
        System.out.println("\n");
        node.printMid();
        System.out.println("\n");
        node.printBehind();
        System.out.println("\n");
    }
}
