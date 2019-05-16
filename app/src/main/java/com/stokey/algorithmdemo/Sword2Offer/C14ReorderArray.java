package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C14ReorderArray {
    /**
     * 调整数组顺序使奇数位于偶数前
     * 【双指针问题】
     *
     * @param input
     */
    public static Integer[] reorder(Integer[] input) {
        if (input == null || input.length <= 1) {
            return null;
        }

        int left = 0, right = input.length - 1;

        while (left < right) {
            // left 需要显示奇数 （找到偶数）
            while (left < right && !isOddNum(input[left])) {
                ++left;
            }

            while (left < right && isOddNum(input[right])) {
                --right;
            }
            // right 需要显示偶数（找到奇数）
            if (left < right) {
                Utils.swap(input, left, right);
            }
        }
        return input;
    }

    private static boolean isOddNum(int num) {
        return (num & 0x1) == 0;
    }
}

class C14Test {
    public static void main(String[] args) {
        Integer[] result = C14ReorderArray.reorder(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        for (int i = 0; i < result.length; i++) {
            System.out.println("i:" + i + "===>" + result[i]);
        }
    }
}