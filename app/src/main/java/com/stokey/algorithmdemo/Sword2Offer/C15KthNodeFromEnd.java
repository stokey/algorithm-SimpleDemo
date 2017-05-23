package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C15KthNodeFromEnd {
    class ListNode<T> {
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

        public ListNode(T value) {
            this.value = value;
            this.nextNode = null;
        }


        public ListNode(T value, ListNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        private T value;
        private ListNode nextNode;
    }

    /**
     * 输出链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode<Integer> findKthNode(ListNode<Integer> head, int k) {
        if (head == null || k <= 0) {
            throw new RuntimeException("input error");
        }

        ListNode<Integer> p1 = head, p2 = head;
        for (int i = 0; i < k; i++) {
            if (i < k && p2.getNextNode() == null) {
                throw new RuntimeException("input error: k number is too large");
            }
            p2 = p2.getNextNode();
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
    public static ListNode<Integer> findMidNode(ListNode<Integer> head) {
        if (head == null) {
            throw new RuntimeException("input error:head is null");
        }

        ListNode<Integer> slow = head, quick = head;

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
    public static boolean isCircle(ListNode<Integer> head) {
        if (head == null) {
            throw new RuntimeException("input error:head is null");
        }

        ListNode<Integer> slow = head, quick = head;

        while (slow.getNextNode() != null && quick.getNextNode() != null && quick.getNextNode().getNextNode() != null) {
            quick = quick.getNextNode().getNextNode();
            slow = slow.getNextNode();
            if (quick != null && slow != null && quick == slow) {
                return true;
            }
        }
        return false;
    }
}
