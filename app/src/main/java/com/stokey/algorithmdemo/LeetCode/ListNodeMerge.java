package com.stokey.algorithmdemo.LeetCode;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class ListNodeMerge {
    public static void main(String[] args) {
        LinkNode tail1 = new LinkNode(5);
        LinkNode mid1 = new LinkNode(4, tail1);
        LinkNode head1 = new LinkNode(1, mid1);

        LinkNode tail2 = new LinkNode(4);
        LinkNode mid2 = new LinkNode(3, tail2);
        LinkNode head2 = new LinkNode(1, mid2);

        LinkNode tail3 = new LinkNode(6);
        LinkNode head3 = new LinkNode(2, tail3);

        System.out.println(mergeKLists(new LinkNode[]{head1, head2, head3}));
    }

    public static LinkNode mergeKLists(LinkNode[] lists) {
        if (lists == null || lists.length <=0) {
            return null;
        }
        return mergeKLists2(lists, 0, lists.length - 1);
    }

    public static LinkNode mergeKLists2(LinkNode[] lists, int start, int end) {
        if (lists == null || lists.length <=0 || start > end) {
            return null;
        }
        return mergeTwoLists(lists[start], mergeKLists2(lists, start + 1, end));
    }

    private static LinkNode mergeTwoLists(LinkNode linkNode1, LinkNode linkNode2) {
        if (linkNode1 == null) {
            return linkNode2;
        }

        if (linkNode2 == null) {
            return linkNode1;
        }

        LinkNode temp1 = linkNode1;
        LinkNode temp2 = linkNode2;
        LinkNode head = null, lastNode = null, currentNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.getValue().compareTo(temp2.getValue()) < 0) {
                currentNode = new LinkNode(temp1.getValue());
                temp1 = temp1.getNextNode();
            } else {
                currentNode = new LinkNode(temp2.getValue());
                temp2 = temp2.getNextNode();
            }
            if (lastNode != null) {
                lastNode.setNextNode(currentNode);
            } else {
                head = currentNode;
            }
            lastNode = currentNode;
        }

        while (temp1 != null) {
            currentNode = new LinkNode(temp1.getValue());
            lastNode.setNextNode(currentNode);
            temp1 = temp1.getNextNode();
            lastNode = currentNode;
        }

        while (temp2 != null) {
            currentNode = new LinkNode(temp2.getValue());
            lastNode.setNextNode(currentNode);
            temp2 = temp2.getNextNode();
            lastNode = currentNode;
        }

        return head;
    }
}
