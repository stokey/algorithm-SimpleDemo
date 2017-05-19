package com.stokey.algorithmdemo.Algorithm.modal;

/**
 * Created by stokey on 2017/5/18.
 */

public class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public Node leftNode;
    public Node rightNode;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node(Key key, Value value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.leftNode = left;
        this.rightNode = right;
    }
}
