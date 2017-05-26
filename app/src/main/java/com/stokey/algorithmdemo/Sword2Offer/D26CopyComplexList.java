package com.stokey.algorithmdemo.Sword2Offer;

import java.util.HashMap;

/**
 * Created by tiangen on 2017/5/26.
 */

public class D26CopyComplexList {
    /**
     * 复制复杂链表
     * 用HashMap存储sibling节点
     *
     * @param head
     * @return
     */
    public static ComplexListNode copy(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        ComplexListNode currentNode = head;
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        while (currentNode != null) {
            map.put(currentNode, currentNode);
            currentNode = currentNode.getNextNode();
        }
        currentNode = head;
        while (currentNode != null) {
            map.get(currentNode).setNextNode(map.get(currentNode).getNextNode());
            map.get(currentNode).setSiblingNode(map.get(currentNode.getSiblingNode()));
            currentNode = currentNode.getNextNode();
        }
        return map.get(head);
    }

    /**
     * 复制复杂链表
     * A--> A' --> B --> B'
     *
     * @param head
     * @return
     */
    public static ComplexListNode copyAdvance(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        ComplexListNode current = head;
        ComplexListNode currentCopy = null;
        // 构造 A --> A' --> B --> B'结构
        while (current != null) {
            currentCopy = new ComplexListNode(current.getValue());
            currentCopy.setSiblingNode(current.getSiblingNode());
            currentCopy.setNextNode(current.getNextNode());
            current.setNextNode(currentCopy);
            current = currentCopy.getNextNode();
        }

        current = head;

        // 把长链表拆分成两链表：
        // 把奇数位置的节点用 next链接起来就是原始链表 A --> B
        // 把偶数位置的节点用 next链接起来就是复制出来的节点 A' --> B'
        ComplexListNode clone = null;
        ComplexListNode result = current.getNextNode();

        while (current != null) {
            clone = current.getNextNode();
            ComplexListNode originNext = clone.getNextNode();
            current.setNextNode(originNext);
            clone.setNextNode(originNext.getNextNode());
            current = current.getNextNode();
        }
        return result;
    }
}

class ComplexListNode {
    private int value;
    private ComplexListNode nextNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ComplexListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ComplexListNode nextNode) {
        this.nextNode = nextNode;
    }

    public ComplexListNode getSiblingNode() {
        return siblingNode;
    }

    public void setSiblingNode(ComplexListNode siblingNode) {
        this.siblingNode = siblingNode;
    }

    private ComplexListNode siblingNode;

    public ComplexListNode(int value, ComplexListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.siblingNode = null;
    }

    public ComplexListNode(int value) {
        this.value = value;
        this.nextNode = null;
        this.siblingNode = null;
    }

    public ComplexListNode() {
        this.value = 0;
        this.nextNode = null;
        this.siblingNode = null;
    }
}

