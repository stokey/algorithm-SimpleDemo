package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

/**
 * Created by stokey on 2017/5/23.
 */

public class C17MergeSortedList {
    /**
     * 合并两个排序链表
     * 迭代
     * 双指针
     *
     * @param first
     * @param second
     * @return
     */
    public static LinkNode<Integer> merge(LinkNode<Integer> first, LinkNode<Integer> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        // 是否使用第一个链表头结点作为头结点
        boolean isFirst = first.getValue().compareTo(second.getValue()) <= 0;
        LinkNode<Integer> head = new LinkNode<>(isFirst ? first.getValue() : second.getValue());
        LinkNode<Integer> index1 = isFirst ? first.getNextNode() : first;
        LinkNode<Integer> index2 = !isFirst ? second.getNextNode() : second;
        LinkNode<Integer> temp = head;
        while (index1 != null && index2 != null) {
            if (index1.getValue().compareTo(index2.getValue()) > 0) {
                temp.setNextNode(new LinkNode<>(index2.getValue()));
                index2 = index2.getNextNode();
            } else {
                temp.setNextNode(new LinkNode<>(index1.getValue()));
                index1 = index1.getNextNode();
            }
            temp = temp.getNextNode();
        }

        while (index1 != null) {
            temp.setNextNode(new LinkNode<>(index1.getValue()));
            index1 = index1.getNextNode();
            temp = temp.getNextNode();
        }

        while (index2 != null) {
            temp.setNextNode(new LinkNode<>(index2.getValue()));
            index2 = index2.getNextNode();
            temp = temp.getNextNode();
        }

        return head;
    }

    /**
     * 合并两个排序链表
     * 递归
     *
     * @param first
     * @param second
     * @return
     */
    public static LinkNode<Integer> mergeRecursion(LinkNode<Integer> first, LinkNode<Integer> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        LinkNode<Integer> node = null;
        if (first.getValue().compareTo(second.getValue()) <= 0) {
            node = first;
            node.setNextNode(mergeRecursion(first.getNextNode(), second));
        } else {
            node = second;
            node.setNextNode(mergeRecursion(first, second.getNextNode()));
        }
        return node;
    }
}

class C17Test {
    public static void main(String[] args) {
        LinkNode<Integer> tail = new LinkNode<>(12);
        LinkNode<Integer> four = new LinkNode<>(8, tail);
        LinkNode<Integer> three = new LinkNode<>(5, four);
        LinkNode<Integer> two = new LinkNode<>(3, three);
        LinkNode<Integer> head1 = new LinkNode<>(1, two);

        LinkNode<Integer> tail2 = new LinkNode<>(16);
        LinkNode<Integer> four2 = new LinkNode<>(10, tail2);
        LinkNode<Integer> three2 = new LinkNode<>(7, four2);
        LinkNode<Integer> two2 = new LinkNode<>(6, three2);
        LinkNode<Integer> head2 = new LinkNode<>(2, two2);

        System.out.println(C17MergeSortedList.merge(head1, head2));

        System.out.println("mergeRecursion:" + C17MergeSortedList.mergeRecursion(head1, head2));
    }
}
