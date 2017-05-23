package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/23.
 */

public class C18SubstructureTree {
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
     * 输入两棵二叉树A和B
     * 判断B是不是A的子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        // TODO：检查输入合法性
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
            result = isSubTree(root1.getLeft(), root2);
        }

        if (!result) {
            // 未找到匹配的树，从右子树开始重新遍历
            result = isSubTree(root1.getRight(), root2);
        }

        return result;
    }

    private static boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        boolean result;
        if (root1 != null && root2 != null) {
            if (root1.getValue() == root2.getValue()) {
                result = doesTree1HasTree2(root1.getLeft(), root2.getLeft());
                if (result) {
                    result = doesTree1HasTree2(root1.getRight(), root2.getRight());
                }
            } else {
                result = false;
            }
        } else if (root1 == null && root2 == null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
