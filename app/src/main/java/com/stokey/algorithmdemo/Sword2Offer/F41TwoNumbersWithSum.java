package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/6.
 */

public class F41TwoNumbersWithSum {
    /**
     * 输入一个递增排序的数组和一个数字value，在数组中查找两个数字。使得其和等于value。
     * 【如果有多对，输出任意一对即可】
     *
     * @param input
     * @param value
     * @return
     */
    public static boolean isContains(int[] input, int value) {
        if (input == null || input.length == 0) {
            throw new RuntimeException("input error");
        }
        boolean find = false;
        int left = 0, right = input.length - 1;
        while (left < right) {
            if (input[left] + input[right] == value) {
                System.out.println("find value: " + input[left] + " " + input[right]);
                find = true;
                break;
            } else if (input[left] + input[right] < value) {
                ++left;
            } else {
                --right;
            }
        }
        return find;
    }

    /**
     * 输入一个正数value，打印所有和为value的连续正数序列（至少含有两个数）
     * 输入：15 ===> 1+2+3+4+5 = 4+5+6 = 7+8
     *
     * @param value
     */
    public static void findContinuousSequence(int value) {
        if (value > 2) {
            int halfNum = (value + 1) / 2;
            int small = 1;
            int big = 2;
            int curSum = small + big;
            while (small < halfNum) {
                if (curSum == value) {
                    printContinuousSequence(small, big);
                }

                while (curSum < value && big < halfNum) {
                    ++big;
                    curSum += big;
                    if (curSum == value) {
                        printContinuousSequence(small, big);
                    }
                }

                curSum -= small;
                ++small;
            }
        }
    }

    private static void printContinuousSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
    }
}
