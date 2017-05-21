package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B08MinNumberInRotatedArray {
    /**
     * 排序时间复杂度O(n),空间复杂度不超过O(n)
     * 待排序数据大小范围[0,k]
     *
     * @param input
     * @param length
     */
    public void sort(int[] input, int length) {
        // 输入合法性检查
        if (input == null || input.length <= 0 || length <= 0) {
            return;
        }

        final int numMax = 100; // k值
        int[] numCountArray = new int[numMax + 1];// 记录不同数值出现的次数
        for (int i = 0; i < numCountArray.length; i++) {
            numCountArray[i] = 0;
        }

        for (int j = 0; j < input.length; j++) {
            int num = input[j];
            if (num < 0 || num > numMax) {
                throw new RuntimeException("input data error,not in range");
            }
            ++numCountArray[num];
        }

        int index = 0;
        // 输出已经记录num出现的次数
        for (int i = 0; i < numMax; i++) {
            int countNums = numCountArray[i];
            if (countNums > 0) {
                for (int j = 0; j < countNums; j++) {
                    input[index] = i;
                    ++index;
                }
            }
        }
    }

    /**
     * 旋转数组的最小数字
     * 二分查找
     *
     * @param input
     * @param length
     * @return
     */
    public int findMin(int[] input, int length) {
        // TODO: 检查输入合法性
        int left = 0, right = length - 1;
        int midIndex = 0;
        while (input[left] >= input[right]) {
            if (right - left == 1) {
                midIndex = right;
                break;
            }
            midIndex = left + (right - left) / 2;
            // 下标为left,mid,left指向三个数字相等时，则只能顺序查找
            if (input[left] == input[right] && input[midIndex] == input[left]) {
                return orderFind(input, left, right);
            }
            if (input[midIndex] >= input[left]) {
                left = midIndex;
            } else if (input[midIndex] <= input[right]) {
                right = midIndex;
            }
        }

        return input[midIndex];
    }

    /**
     * 按顺序查找出第一个打乱顺序的元素
     * [1,0,1,1,1]
     * [1,1,1,0,1]
     *
     * @param input
     * @param left
     * @param right
     * @return
     */
    private int orderFind(int[] input, int left, int right) {
        // TODO: 检查输入合法性
        int result = input[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > input[i]) {
                result = input[i];
            }
        }
        return result;
    }
}
