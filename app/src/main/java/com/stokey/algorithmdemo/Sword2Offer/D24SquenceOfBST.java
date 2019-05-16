package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/25.
 */

public class D24SquenceOfBST {
    /**
     * 判断输入数组是否是某二叉搜索树的后序遍历
     * 输入的数组任意两个数字都互不相同
     * 【后序遍历结果最后一个节点为根节点，"搜索二叉树需要满足左子树所有节点都比根节点小,所有右节点都比根节点大"】
     *
     * @param input
     * @return
     */
    public static boolean verifySequenceOfBST(int[] input) {
        if (input == null || input.length <= 0) {
            return false;
        }
        return verifySequenceOfBST(input, 0, input.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] input, int start, int end) {
        if (input == null || end >= input.length - 1 || start < 0 || end < 0) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        // 根节点
        int root = input[end];

        int index = 0;
        // 在二叉搜索树中找出第一个大于根节点的节点
        while (input[index] < root && index < end - 1) {
            ++index;
        }

        int mid = index;
        // 判断右子树是否满足条件

        while (input[index] > root && index < end - 1) {
            ++index;
        }

        if (index != end - 1) {
            return false;
        }
        return verifySequenceOfBST(input, start, mid - 1) && verifySequenceOfBST(input, mid, end - 1);

    }
}

class D24Test {
    public static void main(String[] args) {
        System.out.println("input array1 is binary search tree:" + D24SquenceOfBST.verifySequenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));

        System.out.println("input array2 is binary search tree:" + D24SquenceOfBST.verifySequenceOfBST(new int[]{7, 4, 6, 5}));
    }
}
