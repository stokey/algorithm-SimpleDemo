package com.stokey.algorithmdemo.Algorithm.model;

/**
 * Created by stokey on 2017/5/18.
 */

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private int count;
    private Node<Key, Value> root;

    public BinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * 返回二叉搜索树节点个数
     *
     * @return
     */
    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 向二叉搜索树中插入一个元素
     *
     * @param root
     * @param key
     * @param value
     * @return
     */
    public Node insert(Node root, Key key, Value value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (root.key.compareTo(key) == 0) {
            root.value = value;
        } else if (root.key.compareTo(key) < 0) {
            root.leftNode = insert(root.leftNode, key, value);
        } else {
            root.rightNode = insert(root.rightNode, key, value);
        }
        return root;
    }

    /**
     * 检测键值为key的元素是否存在
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    private boolean contain(Node<Key, Value> root, Key key) {
        if (root == null) {
            return false;
        }

        if (root.key.compareTo(key) == 0) {
            return true;
        } else if (root.key.compareTo(key) > 0) {
            return contain(root.leftNode, key);
        } else {
            return contain(root.rightNode, key);
        }
    }

    /**
     * 根据键值查找元素值
     *
     * @param key
     * @return
     */
    public Value search(Key key) {
        assert contain(key);
        return search(root, key);
    }

    private Value search(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) == 0) {
            return (Value) root.value;
        } else if (root.key.compareTo(key) > 0) {
            return search(root.leftNode, key);
        } else {
            return search(root.rightNode, key);
        }
    }
}
