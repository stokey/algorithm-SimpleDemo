package com.stokey.algorithmdemo.Algorithm.model;

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

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
