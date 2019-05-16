package com.stokey.algorithmdemo.Algorithm.search;

import java.util.LinkedList;

/**
 * Created by stokey on 2017/5/18.
 */

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private int count;
    private Node root;

    public BinarySearchTree() {
        this.count = 0;
        this.root = null;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * 插入某个节点
     *
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(this.root, key, value);
    }

    private Node insert(Node root, Key key, Value value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(root.key) == 0) {
            root.value = value;
        } else if (key.compareTo(root.key) < 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    /**
     * 检测Key节点是否存在
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(this.root, key);
    }

    private boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        } else if (root.key.compareTo(key) > 0) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
        }
    }

    /**
     * 查找键值为key的节点对应Value值
     *
     * @param key
     * @return
     */
    public Value search(Key key) {
        return search(this.root, key);
    }

    private Value search(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) == 0) {
            return root.value;
        } else if (root.key.compareTo(key) > 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println("preOrder Key: " + root.key + ", Value: " + root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(this.root);
    }

    private void midOrder(Node root) {
        if (root != null) {
            midOrder(root.left);
            System.out.println("midOrder Key: " + root.key + ", Value: " + root.value);
            midOrder(root.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("postOrder Key: " + root.key + ", Value: " + root.value);
        }
    }

    /**
     * 摧毁搜索二叉树（后序遍历实际应用）
     */
    public void destroy() {
        destroy(this.root);
    }

    private void destroy(Node root) {
        if (root != null) {
            destroy(root.left);
            destroy(root.right);
            this.count--;
            root.left = root.right = null;
            root.key = null;
            root.value = null;
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        LinkedList<Node> mList = new LinkedList<>();
        mList.add(this.root);
        while (!mList.isEmpty()) {
            Node node = mList.poll();
            System.out.println("levelOrder Key: " + node.key + ", Value: " + node.value);
            if (node.left != null) {
                mList.push(node.left);
            }
            if (node.right != null) {
                mList.push(node.right);
            }

        }
    }

    /**
     * 寻找最小节点
     *
     * @return
     */
    public Key minimum() {
        assert this.count <= 0;
        return minimum(this.root).key;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    /**
     * 寻找最大节点
     *
     * @return
     */
    public Key maximum() {
        assert this.count <= 0;
        return maximum(this.root).key;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    /**
     * 删除最小节点
     *
     * @return
     */
    public Node removeMin() {
        return this.root == null ? null : removeMin(this.root);
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            Node right = root.right;
            root.right = null;
            this.count--;
            return right;
        }

        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 删除最大节点
     *
     * @return
     */
    public Node removeMax() {
        return this.root == null ? null : removeMax(this.root);
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node left = root.left;
            root.left = null;
            this.count--;
            return left;
        }

        root.right = removeMax(root.right);
        return root;
    }

    /**
     * 根据键值删除某一节点
     *
     * @param key
     */
    public void remove(Key key) {
        this.root = remove(this.root, key);
    }

    private Node remove(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) > 0) {
            return remove(root.left, key);
        } else if (root.key.compareTo(key) < 0) {
            return remove(root.right, key);
        } else {
            if (root.left == null) {
                Node right = root.right;
                root.right = null;
                this.count--;
                return right;
            }
            if (root.right == null) {
                Node left = root.left;
                root.left = null;
                this.count--;
                return left;
            }
            // left/right都不为null
            Node successor = new Node(minimum(root.right));
            this.count++;

            successor.right = removeMin(successor);
            successor.left = root.left;
            root.left = root.right = null;
            this.count--;
            return successor;
        }
    }
}
