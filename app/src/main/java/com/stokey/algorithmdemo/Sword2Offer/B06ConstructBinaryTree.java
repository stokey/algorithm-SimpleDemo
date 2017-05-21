package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Arrays;

/**
 * Created by stokey on 2017/5/21.
 */

class BinaryTreeNode {
    int value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}

public class B06ConstructBinaryTree {
    private static BinaryTreeNode construct(int[] preOrder, int[] midOrder) {
        // TODO：检查输入合法性

        BinaryTreeNode root = null;
        if (preOrder != null && midOrder != null
                && preOrder.length == midOrder.length && midOrder.length > 0) {
            int size = midOrder.length;
            int rootValue = preOrder[0];
            root = new BinaryTreeNode(rootValue);
            int i = -1;
            for (; i < size; i++) {
                if (rootValue == midOrder[i]) {
                    break;
                }
            }

            // 左子树
            root.leftNode = construct(Arrays.copyOfRange(preOrder, 1, i),
                    Arrays.copyOfRange(midOrder, 0, i-1));
            // 右子树
            root.rightNode = construct(Arrays.copyOfRange(preOrder, i + 1, size-1),
                    Arrays.copyOfRange(midOrder, i + 1, size-1));
        }
        return root;
    }
}
