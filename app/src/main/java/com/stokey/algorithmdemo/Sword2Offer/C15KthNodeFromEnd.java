package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C15KthNodeFromEnd {
    /**
     * 输出链表中倒数第k个节点
     * 双指针法
     * @param head
     * @param k
     * @return
     */
    public static LinkNode findKthNode(LinkNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        LinkNode p1 = head, p2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (p2.getNextNode() == null) {
                return null;
            } else {
                p2 = p2.getNextNode();
            }
        }

        while (p2.getNextNode() != null) {
            p1 = p1.getNextNode();
            p2 = p2.getNextNode();
        }
        return p1;
    }

    /**
     * 求链表的中间节点。
     * 如果节点总数为偶数，则返回中间两个节点的任意一个节点。
     * 如果节点总数为奇数，则返回中间节点。
     *
     * @param head
     * @return
     */
    public static LinkNode findMidNode(LinkNode head) {
        if (head == null) {
            return null;
        }

        LinkNode slow = head, quick = head;

        while (quick.getNextNode() != null && quick.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            quick = quick.getNextNode().getNextNode();
        }
        return slow;
    }

    /**
     * 判断链表是否形成环结构
     * 【用步差实现：快的追赶慢的指针】
     *
     * @param head
     * @return
     */
    public static boolean isCircle(LinkNode head) {
        if (head == null) {
            return false;
        }

        LinkNode slow = head, quick = head;

        while (quick.getNextNode() != null && quick.getNextNode().getNextNode() != null) {
            quick = quick.getNextNode().getNextNode();
            slow = slow.getNextNode();
            if (slow != null && quick == slow) {
                return true;
            }
        }
        return false;
    }
}

class C15Test {
    public static void main(String[] args) {
        LinkNode<Integer> tail = new LinkNode<>(5);
        LinkNode<Integer> four = new LinkNode<>(4, tail);
        LinkNode<Integer> three = new LinkNode<>(3, four);
        LinkNode<Integer> two = new LinkNode<>(2, three);
        LinkNode<Integer> head = new LinkNode<>(1, two);
        System.out.println(C15KthNodeFromEnd.findKthNode(head, 2));
        System.out.println("Mid Node:" + C15KthNodeFromEnd.findMidNode(head));
        System.out.println("is Circle Link:" + C15KthNodeFromEnd.isCircle(head));
    }
}
