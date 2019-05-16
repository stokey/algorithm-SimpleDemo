package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.model.LinkNode;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C13DeleteNodeInList {
    /**
     * 在O(1)时间删除链表节点
     * 给定一个单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点
     * @param head
     * @param delete
     */
    public static void delete(LinkNode<Integer> head, LinkNode<Integer> delete) {
        if (head == null || delete == null) {
            throw new RuntimeException("input error: node info can't null");
        }

        if (head == delete && head.getNextNode() == null) {
            // 只有一个节点
            head = null;
        } else if (delete.getNextNode() == null) {
            // 为尾部节点，此时只能从头遍历后进行删除
            LinkNode tempNode = head;
            while (tempNode != null && tempNode.getNextNode() != delete) {
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(null);
        } else {
            LinkNode<Integer> delNext = delete.getNextNode();
            // 将待删除节点信息用delNext节点信息进行替换
            delete.setValue(delNext.getValue());
            delete.setNextNode(delNext.getNextNode());
            // 删除delNext节点信息
            delNext.setNextNode(null);
            delNext.setValue(0);
        }
        delete = null;
    }
}

class C13Test {
    public static void main(String[] args) {
        LinkNode<Integer> head = new LinkNode<Integer>(1);
        LinkNode<Integer> next = new LinkNode<Integer>(2);
        head.setNextNode(next);
        LinkNode<Integer> last = new LinkNode<Integer>(3);
        next.setNextNode(last);
        System.out.println(head);
        C13DeleteNodeInList.delete(head, head);
        System.out.println(head);
    }
}