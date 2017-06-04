package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/6/4.
 */

public class F39BalancedBinaryTree {
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
     * 获取一棵树的深度
     *
     * @param root
     * @return
     */
    public static int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.getLeft());
        int right = deep(root.getRight());
        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * 判断一棵树是否是平衡二叉树
     * 【根据深度差求法：效率不高，同个节点会被多次遍历】
     *
     * @param root
     * @return
     */
    public static boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = deep(root.getLeft());
        int right = deep(root.getRight());
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanceTree(root.getLeft()) && isBalanceTree(root.getRight());
    }

    /**
     * 判断一棵树是否是平衡二叉树
     * 【根据后续遍历方式：能保证每个节点只被遍历一次】
     *
     * @param root
     * @return
     */
    public static boolean isBalanceTreeAdvance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isAdvance(root, 0);
    }

    private static boolean isAdvance(TreeNode root, int deep) {
        if (root == null) {
            deep = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isAdvance(root.getLeft(), left) && isAdvance(root.getRight(), right)) {
            int diff = Math.abs(left - right);
            if (diff <= 1) {
                deep = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }
}
