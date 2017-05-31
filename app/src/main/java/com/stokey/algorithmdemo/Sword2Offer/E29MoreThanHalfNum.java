package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/31.
 */

public class E29MoreThanHalfNum {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，找出该数字
     * <p>
     * 中位数问题——长度为n的数组中第n/2大的数字
     * Partition函数思想O(n)
     *
     * @param input
     * @return
     */
    public static int halfNum(int[] input) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input error");
        }
        int length = input.length;
        int mid = length / 2;
        int partitionIndex = partition(input, 0, length - 1);

        while (partitionIndex != mid) {
            if (partitionIndex > mid) {
                partitionIndex = partition(input, 0, partitionIndex - 1);
            } else {
                partitionIndex = partition(input, partitionIndex + 1, length - 1);
            }
        }
        int result = input[mid];
        if (!check(input, result)) {
            throw new RuntimeException("not exist");
        }
        return result;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，找出该数字
     * <p>
     * 数组中有一个数字出现的次数超过数组长度的一半，则它出现的次数比其他所有数字出现的次数还要多
     * 时间复杂度O(n)
     *
     * @param input
     * @return
     */
    public static int halfNum2(int[] input) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input error");
        }

        int count = 0;
        int lastNum = input[0];
        for (int i = 0; i < input.length; i++) {
            if (count == 0) {
                lastNum = input[i];
                ++count;
            } else if (lastNum != input[i]) {
                --count;
            } else {
                ++count;
            }
        }
        if (!check(input, lastNum)) {
            throw new RuntimeException("not exist");
        }
        return lastNum;
    }

    /**
     * 检测合法性
     *
     * @param input
     * @param result
     * @return
     */
    private static boolean check(int[] input, int result) {
        int times = 0;
        int length = input.length;
        for (int i = 0; i < length; i++) {
            if (input[i] == result) {
                ++times;
            }
        }
        if (times * 2 <= length) {
            return false;
        }
        return true;
    }

    /**
     * 分治思想
     *
     * @param input
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] input, int left, int right) {
        if (input == null || input.length <= 0 || left < 0 || left >= right) {
            throw new RuntimeException("partition input error");
        }
        int temp = input[left];
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && input[i] <= temp) i++;
            while (j >= left + 1 && input[j] >= temp) j--;

            if (i > j) {
                break;
            }
            swap(input, i, j);
            i++;
            j--;
        }
        swap(input, left, j);
        return j;
    }

    private static void swap(int[] input, int i, int j) {
        if (input == null || input.length <= 0 ||
                input.length <= i || input.length <= j || i < 0 || j < 0) {
            return;
        }
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}
