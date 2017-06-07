package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/7.
 */

public class F44ContinousCards {
    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子（连续）
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，大、小王可以看成任意数字
     * 解法：
     * 5张牌可以看成5个数字组成的数组，大、小王是特殊的数字。可定义为0
     * 1. 数组排序
     * 2. 统计数组中0的个数
     * 3. 统计排序后的数组中相邻数字之间的空缺总数
     *
     * @param input
     * @param length
     * @return
     */
    public static boolean isContinuous(int[] input, int length) {
        if (input == null || input.length < 1 || length < 1) {
            return false;
        }
        // TODO: 快速排序数组
        quickSort(input, length, 0, length - 1);

        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < length && input[i] == 0; i++) {
            ++numberOfZero;
        }

        int smallIndex = numberOfGap;
        int bigIndex = smallIndex + 1;

        while (bigIndex < length) {
            // 两个数相等，则不可能是顺子
            if (input[bigIndex] == input[smallIndex]) {
                return false;
            }
            numberOfGap += input[bigIndex] - input[smallIndex] - 1;
            smallIndex = bigIndex;
            ++bigIndex;
        }
        return numberOfGap <= numberOfZero;
    }

    private static void quickSort(int[] input, int length, int left, int right) {
        if (left < right) {
            int partitionIndex = quickSort(input, left, right);
            quickSort(input, length, 0, partitionIndex - 1);
            quickSort(input, length, partitionIndex + 1, length - 1);
        }
    }

    private static int quickSort(int[] input, int left, int right) {
        if (input != null && input.length > 0 && left < right) {
            int temp = input[0];
            int i = left + 1, j = right;
            while (true) {
                while (i <= j && input[i] <= temp) ++i;
                while (j >= left + 1 && input[i] >= temp) j--;
                if (i >= j) {
                    break;
                }
                swap(input, i, j);
                ++i;
                --j;
            }
            swap(input, left, j);
            return j;
        }
        return -1;
    }

    private static void swap(int[] input, int left, int right) {
        if (input == null || left < 0 || right < 0 || left > right || input.length <= right) {
            throw new IllegalArgumentException("input error");
        }
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
