package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by stokey on 2017/5/21.
 */

public class B05printListInverseNode {

    public class ListNode<Key extends Comparable<Key>, Value> {
        Key key;
        Value value;
        ListNode next;

        public ListNode(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public ListNode(Key key, Value value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 递归方式从尾到头打印链表
     *
     * @param head
     */
    public static void printListByRecursion(ListNode head) {
        if (head == null) {
            return;
        }
        printListByRecursion(head.next);
        System.out.println("Key:" + head.key + ", Value:" + head.value);
    }

    public static void printListByStack(ListNode head) {
        Stack stack = new Stack();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            ListNode last = (ListNode) stack.pop();
            System.out.println("Key:" + last.key + ", Value:" + last.value);
        }
    }
}
