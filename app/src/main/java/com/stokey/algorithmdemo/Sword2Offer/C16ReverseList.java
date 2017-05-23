package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C16ReverseList {
    class LinkNode<T> {
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public LinkNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(LinkNode nextNode) {
            this.nextNode = nextNode;
        }

        public LinkNode(T value) {
            this.value = value;
            this.nextNode = null;
        }


        public LinkNode(T value, LinkNode nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        private T value;
        private LinkNode nextNode;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static LinkNode<Integer> reverse(LinkNode<Integer> head) {
        if (head == null) {
            return head;
        }

        return head;
    }
}
