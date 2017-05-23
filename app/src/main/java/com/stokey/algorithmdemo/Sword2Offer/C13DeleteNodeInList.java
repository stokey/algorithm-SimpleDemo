package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C13DeleteNodeInList {
    class Node<T> {

        public Node(T value) {
            this.value = value;
            this.nextNode = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.nextNode = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        private T value;
        private Node<T> nextNode;
    }

    /**
     * 在O(1)时间删除链表节点
     *
     * @param head
     * @param delete
     */
    public static void delete(Node<Integer> head, Node<Integer> delete) {
        if (head == null || delete == null) {
            throw new RuntimeException("input error: node info can't null");
        }

        if (head == delete) {
            head.setNextNode(null);
            delete.setNextNode(null);
            head.setValue(0);
            delete.setValue(0);
            head = delete = null;
        } else if (delete.getNextNode() == null) {
            // 为尾部节点，此时只能从头遍历后进行删除
            while (head.getNextNode() != delete) {
                head = head.getNextNode();
            }
            head.setNextNode(null);
            head.setValue(0);
            delete = null;
        } else {
            Node<Integer> delNext = delete.getNextNode();
            // 将待删除节点信息用delNext节点信息进行替换
            delete.setValue(delNext.getValue());
            delete.setNextNode(delNext.getNextNode());
            // 删除delNext节点信息
            delNext.setNextNode(null);
            delNext.setValue(0);
            delNext = null;
        }

    }
}
