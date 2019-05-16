package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by tiangen on 2017/5/25.
 */

public class D25PathInTree {
    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
     * 从根节点开始往下一直到叶节点所经过的节点形成一条路径
     * 分析：
     * 通过前序遍历方式遍历二叉树，并且把当前遍历路径存储到当前栈结构中
     *
     * @param root
     * @param exceptedSum
     */
    public static int findPath(BinaryTreeNode<Integer> root, int exceptedSum) {
        if (root == null) {
            return 0;
        }
        Stack<BinaryTreeNode<Integer>> path = new Stack<>();
        return findPath(root, path, 0, exceptedSum);
    }

    private static int findPath(BinaryTreeNode<Integer> root, Stack<BinaryTreeNode<Integer>> path, int currentSum, int exceptedSum) {
        int result = 0;
        currentSum += root.getValue();
        path.push(root);
        // 确保是叶子节点
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            if (currentSum == exceptedSum) {
                printPath(path);
                return 1;
            } else {
                // 当前路径不满足条件则退后到父节点
                path.pop();
            }
        }
        if (root.getLeftNode() != null) {
            result += findPath(root.getLeftNode(), path, currentSum, exceptedSum);
        }

        if (root.getRightNode() != null) {
            result += findPath(root.getRightNode(), path, currentSum, exceptedSum);
        }
        return result;
    }

    private static void printPath(Stack path) {
        if (path == null || path.isEmpty()) {
            System.out.println("path is null");
        } else {
            int i = path.size();
            BinaryTreeNode<Integer> peek;
            System.out.println("======path start======");
            while ( i > 1) {
                peek = (BinaryTreeNode<Integer>) path.pop();
                System.out.println("path node is:" + peek.getValue());
                i--;
            }
            // 保持头结点一直在栈中
            peek = (BinaryTreeNode<Integer>) path.peek();
            System.out.println("path node is:" + peek.getValue());
            System.out.println("======path end======\n");
        }
    }
}

class D25Test {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> leftLeafNode = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rightLeafNode = new BinaryTreeNode<Integer>(7);
        BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(5, leftLeafNode, rightLeafNode);
        BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(12);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10, leftNode, rightNode);
        System.out.println("path num:" + D25PathInTree.findPath(root, 22));
    }
}
