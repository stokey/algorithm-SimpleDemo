package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/6/4.
 */

public class F38NumberOfK {
    /**
     * 数字在排序数组中出现的次数
     * 二分查找法——找到位置后，分别向左和向右遍历，找最左端元素和最右端元素相同元素下标
     * 【直接法：最坏时间复杂度为O(N)】
     * @param input
     * @param value
     * @return
     */
    public static int getNumber(int[] input, int value) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input is array is null");
        }

        int tempIndex = getValueIndex(input, 0, input.length, value);
        int leftIndex = tempIndex;//最开始位置下标
        int rightIndex = tempIndex;//最后位置下标
        for (int i = leftIndex - 1; i >= 0; i--) {
            if (value == input[i]) {
                leftIndex = i;
            } else {
                break;
            }
        }
        for (int j = rightIndex + 1; rightIndex < input.length; j++) {
            if (value == input[j]) {
                rightIndex = j;
            } else {
                break;
            }
        }
        int num = 0;
        if (rightIndex >= 0 && leftIndex >= 0) {
            num = rightIndex - leftIndex + 1;
        }
        return num;
    }

    private static int getValueIndex(int[] input, int start, int end, int value) {
        int result = -1;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int temp = input[mid];
            if (value == temp) {
                result = mid;
            } else if (value > temp) {
                return getValueIndex(input, mid + 1, end, value);
            } else {
                return getValueIndex(input, start, mid - 1, value);
            }
        }
        return result;
    }

    /**
     * 数字在排序数组中出现的次数
     * 二分查找法——找值相同的元素的最左端元素和最右端元素元素下标
     * 【间接：时间复杂度为 2 * O(logN)】
     * @param input
     * @param value
     * @return
     */
    public static int getNumberAdvance(int[] input,int value){
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input is array is null");
        }
        int firstIndex = getFirstValueNum(input,input.length,0,input.length-1,value);
        int lastIndex = getLastValueNum(input,input.length,0,input.length-1,value);
        int num = 0;
        if (firstIndex >= 0 && lastIndex >= 0) {
            num = lastIndex - firstIndex + 1;
        }
        return num;
    }

    private static int getFirstValueNum(int[] input,int length, int start, int end, int value) {
        int result = -1;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int temp = input[mid];
            if (value == temp) {
                if (mid > 0 && input[mid-1] == value){
                    --mid;
                }
                return mid;
            } else if (value > temp) {
                return getFirstValueNum(input,length, mid + 1, end, value);
            } else {
                return getFirstValueNum(input,length, start, mid - 1, value);
            }
        }
        return result;
    }

    private static int getLastValueNum(int[] input,int length, int start, int end, int value) {
        int result = -1;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            int temp = input[mid];
            if (value == temp) {
                if (mid < length-1 && input[mid+1] == value){
                    ++mid;
                }
                return mid;
            } else if (value > temp) {
                return getLastValueNum(input,length, mid + 1, end, value);
            } else {
                return getLastValueNum(input,length, start, mid - 1, value);
            }
        }
        return result;
    }
}
