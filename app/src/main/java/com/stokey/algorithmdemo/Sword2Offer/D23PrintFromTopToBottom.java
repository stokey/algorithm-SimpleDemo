package com.stokey.algorithmdemo.Sword2Offer;

import java.util.LinkedList;

/**
 * Created by tiangen on 2017/5/25.
 */

public class D23PrintFromTopToBottom {
    class TreeNode<T> {
        private T value;
        private TreeNode left;
        private TreeNode right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 从上往下打印二叉树
     * 二叉树的层序遍历
     *
     * @param root
     */
    public static void printV(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        LinkedList list = new LinkedList();
        list.push(root);

        while (!list.isEmpty()) {
            TreeNode node = (TreeNode) list.poll();
            System.out.println("Value:" + node.getValue());

            if (node.getLeft() != null) {
                list.push(node.getLeft());
            }

            if (node.getRight() != null) {
                list.push(node.getRight());
            }
        }
    }
}
