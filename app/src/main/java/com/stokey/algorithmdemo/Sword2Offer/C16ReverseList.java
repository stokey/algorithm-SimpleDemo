package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C16ReverseList {
    /**
     * 反转链表
     * 三个指针
     * 1. 当前遍历到的节点
     * 2. 当前节点的上一个节点
     * 3. 当前节点的下一个节点
     * @param head
     * @return
     */
    public static LinkNode reverse(LinkNode head) {
        if (head == null) {
            return head;
        }
        LinkNode reversedHead = null;
        // 当前遍历节点
        LinkNode currentNode = head;
        // 当前遍历节点的上一个节点
        LinkNode preNode = null;
        while (currentNode != null) {
            // 当前遍历节点的下一个节点
            LinkNode pNext = currentNode.getNextNode();
            if (pNext == null) {
                // 链表尾部
                reversedHead = currentNode;
            }
            currentNode.setNextNode(preNode);
            preNode = currentNode;
            currentNode = pNext;
        }
        return reversedHead;
    }
}

class C16Test {
    public static void main(String[] args) {
        LinkNode<Integer> tail = new LinkNode<>(5);
        LinkNode<Integer> four = new LinkNode<>(4, tail);
        LinkNode<Integer> three = new LinkNode<>(3, four);
        LinkNode<Integer> two = new LinkNode<>(2, three);
        LinkNode<Integer> head = new LinkNode<>(1, two);

        System.out.println(C16ReverseList.reverse(head));
    }
}
