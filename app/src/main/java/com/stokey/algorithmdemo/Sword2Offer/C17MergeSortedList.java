package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/23.
 */

public class C17MergeSortedList {
    class Node<T> {
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node(T value) {
            this.value = value;
            this.nextNode = null;
        }


        public Node(T value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        private T value;
        private Node nextNode;
    }

    /**
     * 合并两个排序链表
     * 迭代
     *
     * @param first
     * @param second
     * @return
     */
    public static Node<Integer> merge(Node<Integer> first, Node<Integer> second) {
        // TODO: 检查输入合法性
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        Node<Integer> head = first.getValue() <= second.getValue() ? first : second;
        Node<Integer> index1 = head == first ? first.getNextNode() : first;
        Node<Integer> index2 = head == second ? second.getNextNode() : second;
        while (index1 != null && index2 != null) {
            if (index1.getValue() > index2.getValue()) {
                head.setNextNode(index2);
                index2 = index2.getNextNode();
            } else {
                head.setNextNode(index1);
                index1 = index1.getNextNode();
            }
            head = head.getNextNode();
        }

        while (index1 != null) {
            head.setNextNode(index1);
            index1 = index1.getNextNode();
            head = head.getNextNode();
        }

        while (index2 != null) {
            head.setNextNode(index2);
            index2 = index2.getNextNode();
            head = head.getNextNode();
        }

        return first.getValue() <= second.getValue() ? first : second;
    }

    /**
     * 合并两个排序链表
     * 递归
     *
     * @param first
     * @param second
     * @return
     */
    public static Node<Integer> mergeSuc(Node<Integer> first, Node<Integer> second) {
        // TODO: 检查输入合法性
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        Node node = null;
        if (first.getValue() <= second.getValue()) {
            node = first;
            node.setNextNode(mergeSuc(first.getNextNode(), second));
        } else {
            node = second;
            node.setNextNode(mergeSuc(first, second.getNextNode()));
        }
        return node;
    }
}
