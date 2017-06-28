package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/23.
 */

public class D19MirrorOfBinaryTree {
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
     * 二叉树的镜像
     * @param head
     * @return
     */
    public static TreeNode<Integer> mirror(TreeNode<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.getLeft() == null && head.getRight() == null) {
            return head;
        }
        TreeNode<Integer> temp = head.getLeft();
        head.setLeft(head.getRight());
        head.setRight(temp);
        if (head.getLeft() != null) {
            mirror(head.getLeft());
        }
        if (head.getRight() != null) {
            mirror(head.getRight());
        }
        return head;
    }
}
