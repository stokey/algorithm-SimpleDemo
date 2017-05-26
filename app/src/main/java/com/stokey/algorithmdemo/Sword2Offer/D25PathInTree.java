package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by tiangen on 2017/5/25.
 */

public class D25PathInTree {
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
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
     * 从根节点开始往下一直到叶节点所经过的节点形成一条路径
     * @param root
     * @param exceptedSum
     */
    public static void findPath(TreeNode<Integer> root, int exceptedSum) {
        // TODO: 检查输入合法性
        if (root == null) {
            throw new RuntimeException("error:input tree root is null");
        }

        Stack path = new Stack();
        findPath(root, path, 0, exceptedSum);
    }

    private static void findPath(TreeNode<Integer> root, Stack path, int currentSum, int exceptedSum) {
        currentSum += root.getValue();
        path.push(root);
        // 确保是叶子节点
        if (root.getLeft() == null && root.getRight()==null
                &&currentSum == exceptedSum){
            printPath(path);
            return;
        }
        if (root.getLeft()!=null){
            findPath(root.getLeft(),path,currentSum,exceptedSum);
        }

        if (root.getRight()!=null){
            findPath(root.getRight(),path,currentSum,exceptedSum);
        }
        // 没找到则回退到父节点
        path.pop();
    }

    private static void printPath(Stack path) {
        if (path == null || path.isEmpty()){
            System.out.println("path is null");
        } else {
            while (!path.isEmpty()){
                TreeNode<Integer> peek = (TreeNode<Integer>) path.pop();
                System.out.println("path node is:"+ peek.getValue());
            }
        }
    }
}
