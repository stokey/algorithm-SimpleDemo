package com.stokey.algorithmdemo.Sword2Offer;

import java.util.LinkedList;

/**
 * Created by tiangen on 2017/5/26.
 */

public class D27ConvertBinnarySearchTree {

    /**
     * 输入一个二叉搜索树，将该二叉搜索树转换成一个排序的双向链表[不能产生新的节点]
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static DoubleLinkNode convert(DoubleLinkNode root) {
        if (root == null) {
            return null;
        }
        LinkedList linkList = new LinkedList();
        inOrderToQueue(root, linkList);

        root = (DoubleLinkNode) linkList.poll();
        DoubleLinkNode pre = root;
        pre.left = null;
        DoubleLinkNode current = null;
        while (!linkList.isEmpty()) {
            current = (DoubleLinkNode) linkList.poll();
            pre.right = current;
            current.left = pre;
            pre = current;
        }
        // 最后一个元素right为null【current maybe null】
        pre.right = null;
        return root;
    }

    private static void inOrderToQueue(DoubleLinkNode root, LinkedList linkList) {
        if (root == null || linkList == null) {
            return;
        }
        inOrderToQueue(root.left, linkList);
        linkList.push(root);
        inOrderToQueue(root.right, linkList);
    }

    /**
     * 输入一个二叉搜索树，将该二叉搜索树转换成一个排序的双向链表[不能产生新的节点]
     * 用指针记录上次处理完成当前链表尾节点
     * @param head
     * @return
     */
    public static DoubleLinkNode convert2(DoubleLinkNode head) {
        if (head == null) {
            return null;
        }
        return null;
    }
}

class DoubleLinkNode {
    public int value;
    public DoubleLinkNode left;
    public DoubleLinkNode right;

    public DoubleLinkNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public DoubleLinkNode(int value, DoubleLinkNode left, DoubleLinkNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
