package com.stokey.algorithmdemo.Algorithm.model;

/**
 * 二叉树结构
 * 二叉树特性：
 * 所有子节点不能大于父节点
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    public T value;
    public BinaryTreeNode<T> leftNode;
    public BinaryTreeNode<T> rightNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode(T value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> leftNode, BinaryTreeNode<T> rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void printPre() {
        System.out.print(value + "--->");
        if (leftNode != null) {
            leftNode.printPre();
        }
        if (rightNode != null) {
            rightNode.printPre();
        }
    }

    public void printMid() {
        if (leftNode != null) {
            leftNode.printMid();
        }
        System.out.print(value + "--->");
        if (rightNode != null) {
            rightNode.printMid();
        }
    }

    public void printBehind() {
        if (leftNode != null) {
            leftNode.printBehind();
        }
        if (rightNode != null) {
            rightNode.printBehind();
        }
        System.out.print(value + "--->");
    }
}
