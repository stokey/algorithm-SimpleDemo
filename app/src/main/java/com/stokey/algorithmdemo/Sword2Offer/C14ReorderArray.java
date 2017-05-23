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
    public static void reorder(Integer[] input) {
        // TODO:检查输入合法性
        if (input == null || input.length <= 1) {
            return;
        }

        int left = 0, right = input.length - 1;

        while (left < right) {
            while (left < right && isOddNum(input[left])) {
                ++left;
            }

            while (left < right && !isOddNum(input[right])) {
                --right;
            }

            if (left < right) {
                Utils.swap(input, left, right);
            }
        }
    }

    private static boolean isOddNum(int num) {
        return (num & 0x1) == 0;
    }
}
