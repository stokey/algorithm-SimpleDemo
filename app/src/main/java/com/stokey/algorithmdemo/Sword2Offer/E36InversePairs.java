package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/6/2.
 */

public class E36InversePairs {
    /**
     * 输入一个数组，求这个数组中的逆序对的总数
     * 【逆序对：数组中连个数字如果前面一个数组大于后面的数字，则为一个逆序对】
     * <p>
     * 归并方式处理【先将数组划分子数组。
     * 再将子数组进行合并的时候采用双指针的方式统计两个子数组之间存在的逆序对】
     *
     * @param input
     */
    public static int inversePairs(int[] input) {
        int ivpNum = 0;
        if (input != null && input.length > 1) {
            int[] copy = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                copy[i] = input[i];
            }
            ivpNum = inversePairsCore(input, copy, 0, input.length - 1);
        }
        return ivpNum;
    }

    private static int inversePairsCore(int[] input, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = input[end];
            return 0;
        }
        int mid = (end - start) / 2;
        int leftNum = inversePairsCore(input, copy, start, start + mid);
        int rightNum = inversePairsCore(input, copy, start + mid + 1, end);

        int i = start + mid; // 左边数组最后一个元素下标
        int j = end; // 右边数组最后一个数组

        int copyIndex = end;
        int count = 0;
        // 统计两个子数组合并时存在的逆序对数
        while (i >= start && j >= start + mid + 1) {
            if (input[i] > input[j]) {
                copy[copyIndex--] = input[i--];
                count += j - start - mid;
            } else {
                copy[copyIndex--] = input[j--];
            }
        }

        for (; i >= start; --i) {
            copy[copyIndex--] = input[i];
        }

        for (; j >= start + mid + 1; --j) {
            copy[copyIndex--] = input[j];
        }
        count += leftNum + rightNum;
        return count;
    }
}
