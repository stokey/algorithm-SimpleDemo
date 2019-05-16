package com.stokey.algorithmdemo.LeetCode;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;
import java.util.Stack;

/**
 * 链表加法
 */
public class TwoListNodePlus {
    public static void main(String[] args) {
        LinkNode tailT1 = new LinkNode(4);
        LinkNode midT1 = new LinkNode(4, tailT1);
        LinkNode headT1 = new LinkNode(2, midT1);

        LinkNode tailT2 = new LinkNode(4);
        LinkNode midT2 = new LinkNode(6, tailT2);
        LinkNode headT2 = new LinkNode(5, midT2);
        System.out.println(add(headT1, headT2));

        LinkNode tail1 = new LinkNode(4);
        LinkNode mid1 = new LinkNode(3, tail1);
        LinkNode head1 = new LinkNode(6, mid1);

        LinkNode mid2 = new LinkNode(8, null);
        LinkNode head2 = new LinkNode(2, mid2);

        System.out.println(addReverse(head1, head2));
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param v1
     * @param v2
     * @return
     */
    public static LinkNode add(LinkNode v1, LinkNode v2) {
        // 先要找到位置
        if (v1 == null) {
            return v2;
        }
        if (v2 == null) {
            return v1;
        }
        LinkNode dummyHead = new LinkNode(0);
        LinkNode tempV1 = v1, tempV2 = v2, curr = dummyHead;
        int takeOver = 0;
        while (tempV1 != null || tempV2 != null) {
            int x = (tempV1 != null) ? (int)tempV1.getValue() : 0;
            int y = (tempV2 != null) ? (int)tempV2.getValue() : 0;
            int sum = takeOver + x + y;
            takeOver = sum / 10;
            curr.setNextNode(new LinkNode(sum % 10));
            curr = curr.getNextNode();
            if (tempV1 != null) {
                tempV1 = tempV1.getNextNode();
            }
            if (tempV2 != null) {
                tempV2 = tempV2.getNextNode();
            }
        }
        if (takeOver > 0) {
            curr.setNextNode(new LinkNode(takeOver));
        }
        return dummyHead.getNextNode();
    }

    /**
     * 用链表表示多位数相加
     * 输入：6 --> 3 --> 4    2--> 8
     * 输出：6 --> 6 --> 2
     * 因为 634+28=662
     * @param v1
     * @param v2
     * @return
     */
    public static LinkNode addReverse(LinkNode v1, LinkNode v2) {
        // 先要找到位置
        if (v1 == null) {
            return v2;
        }
        if (v2 == null) {
            return v1;
        }
        Stack<Integer> listV1 = new Stack();
        Stack<Integer> listV2 = new Stack();
        LinkNode tempV1 = new LinkNode(v1.getValue());
        tempV1.setNextNode(v1.getNextNode());
        LinkNode tempV2 = new LinkNode(v2.getValue());
        tempV2.setNextNode(v2.getNextNode());
        while (tempV1 != null) {
            listV1.push((Integer) tempV1.getValue());
            tempV1 = tempV1.getNextNode();
        }

        while (tempV2 != null) {
            listV2.push((Integer) tempV2.getValue());
            tempV2 = tempV2.getNextNode();
        }

        LinkNode tailNode = null, currentNode = null;
        int takeOver = 0;
        while (!listV1.isEmpty() || !listV2.isEmpty()) {
            int x = listV1.isEmpty() ? 0 : listV1.pop();
            int y = listV2.isEmpty() ? 0 : listV2.pop();
            int value = takeOver + x + y;
            takeOver = value / 10;
            currentNode = new LinkNode(value % 10);
            currentNode.setNextNode(tailNode);
            tailNode = currentNode;
        }

        if (takeOver > 0) {
            currentNode = new LinkNode(takeOver);
            currentNode.setNextNode(tailNode);
        }
        return currentNode;
    }
}
