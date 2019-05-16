package com.stokey.algorithmdemo.Algorithm.model;

/**
 * 单向链表结构
 * @param <T>
 */
public class LinkNode<T extends Comparable<T>> {
    private T value;
    private LinkNode<T> nextNode;

    public LinkNode(T value) {
        this.value = value;
        this.nextNode = null;
    }


    public LinkNode(T value, LinkNode<T> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return value + (nextNode != null ? "--->" + nextNode.toString() : "");
    }
}
