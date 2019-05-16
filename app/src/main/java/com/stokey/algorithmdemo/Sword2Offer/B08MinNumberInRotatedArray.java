package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B08MinNumberInRotatedArray {
    /**
     * 排序时间复杂度O(n),空间复杂度不超过O(n)
     * 待排序数据大小范围[0,k]
     * 统计2万名员工年龄人数分布
     *
     * @param input
     * @param length
     */
    public static void sort(int[] input, int maxNum, int length) {
        // 输入合法性检查
        if (input == null || input.length <= 0 || length <= 0 || maxNum > length) {
            return;
        }
        // 记录不同数值出现的次数
        int[] numCountArray = new int[maxNum + 1];
        for (int i = 0; i < numCountArray.length; i++) {
            numCountArray[i] = 0;
        }

        for (int j = 0; j < input.length; j++) {
            int num = input[j];
            if (num < 0 || num > maxNum) {
                throw new RuntimeException("input data error,not in range");
            }
            ++numCountArray[num];
        }
    }

    /**
     * 旋转数组的最小数字
     * 二分查找
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组最小值为1
     *
     * @param input
     * @param length
     * @return
     */
    public static int findMin(int[] input, int length) {
        if (input == null || input.length != length) {
            return -1;
        }
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
    private static int orderFind(int[] input, int left, int right) {
        int result = input[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > input[i]) {
                result = input[i];
                break;
            }
        }
        return result;
    }
}

class TestB08 {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{3, 4, 5, 1, 2};
        int min1 = B08MinNumberInRotatedArray.findMin(numbers1, numbers1.length);
        System.out.println("min1:" + min1);

        int[] numbers2 = new int[]{1, 1, 1, 0, 1};
        int min2 = B08MinNumberInRotatedArray.findMin(numbers2, numbers2.length);
        System.out.println("min2:" + min2);
    }
}
