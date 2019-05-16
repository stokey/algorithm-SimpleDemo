package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

import java.util.Stack;

/**
 * Created by stokey on 2017/6/4.
 */

public class E37FirstCommonNodesLists {

    /**
     * 找出两个链表的共同节点
     * <p>
     * 根据单链表性质可知：如果两个链表有共同节点则链表成Y形状出现，不可能成X形状出现
     * 从后往前遍历节点[先进后出]，直到遇见不同节点。时间复杂度O(n+m),空间复杂度O(n+m)
     *
     * @param first
     * @param second
     * @return
     */
    public static LinkNode<Integer> getCommonNode(LinkNode<Integer> first, LinkNode<Integer> second) {
        if (first == null || second == null) {
            throw new RuntimeException("input error");
        }
        Stack stackFirst = new Stack();
        Stack stackSecond = new Stack();
        while (first != null) {
            stackFirst.push(first);
            first = first.getNextNode();
        }

        while (second != null) {
            stackFirst.push(second);
            second = second.getNextNode();
        }

        LinkNode<Integer> result = null;
        while (!stackFirst.isEmpty() && !stackSecond.isEmpty()) {
            if (stackFirst.peek() != stackSecond.peek()) {
                return result;
            } else {
                result = (LinkNode<Integer>) stackFirst.pop();
                stackSecond.pop();
            }
        }
        return result;
    }

    /**
     * 找出两个链表的共同节点
     * <p>
     * 根据单链表性质可知：如果两个链表有共同节点则链表成Y形状出现，不可能成X形状出现
     * 根据函数求出链表长度，长度较长的链表先移动相同长度位置，然后两个链表同步向下移动，直到遇到相同元素
     * 时间复杂度O(n+m),空间复杂度O(0)
     *
     * @param first
     * @param second
     * @return
     */
    public static LinkNode<Integer> getCommonNodeAdvance(LinkNode<Integer> first, LinkNode<Integer> second) {
        int firstLen = getListLen(first);
        int secondLen = getListLen(second);
        LinkNode<Integer> longList = null;
        LinkNode<Integer> shortList = null;
        int plus = 0;
        if (firstLen > secondLen) {
            longList = first;
            shortList = second;
            plus = firstLen - secondLen;
        } else {
            longList = second;
            shortList = first;
            plus = secondLen - firstLen;
        }
        while (plus > 0) {
            longList = longList.getNextNode();
            --plus;
        }
        while (longList != null && shortList != null) {
            if (longList == shortList) {
                return longList;
            } else {
                longList = longList.getNextNode();
                shortList = shortList.getNextNode();
            }
        }
        return null;
    }

    private static int getListLen(LinkNode node) {
        int result = 0;
        LinkNode head = node;
        while (head != null) {
            ++result;
            head = head.getNextNode();
        }
        return result;
    }
}
