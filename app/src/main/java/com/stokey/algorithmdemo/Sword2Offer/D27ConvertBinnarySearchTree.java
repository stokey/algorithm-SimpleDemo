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
    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList linkList = new LinkedList();
        inOrderToQueue(root, linkList);

        root = (TreeNode) linkList.poll();
        TreeNode pre = root;
        pre.left = null;
        TreeNode current = null;
        while (!linkList.isEmpty()) {
            current = (TreeNode) linkList.poll();
            pre.right = current;
            current.left = pre;
            pre = current;
        }
        // 最后一个元素right为null【current maybe null】
        pre.right = null;
        return root;
    }

    private static void inOrderToQueue(TreeNode root, LinkedList linkList) {
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
    public static TreeNode convert2(TreeNode head) {
        if (head == null) {
            return null;
        }
        return null;
    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
