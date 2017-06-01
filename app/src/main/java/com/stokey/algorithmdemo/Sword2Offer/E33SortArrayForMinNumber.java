package com.stokey.algorithmdemo.Sword2Offer;

import com.stokey.algorithmdemo.Algorithm.util.Utils;

import java.util.Comparator;

/**
 * Created by tiangen on 2017/6/1.
 */

public class E33SortArrayForMinNumber {

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数字
     * 确保输出的数字为所有排列中最小
     * <p>
     * 等价于：通过一种排序规则，将数组排序后能排成一个最小的数字
     *
     * @param input
     * @return
     */
    public static String printMinNumber(String[] input) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input error");
        }

        quickSort(input, 0, input.length - 1, new StringComparator());
        StringBuilder builder = new StringBuilder();
        for (String str : input) {
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * 快速排序
     *
     * @param input
     * @param left
     * @param right
     * @param stringComparator
     */
    private static void quickSort(String[] input, int left, int right, StringComparator stringComparator) {
        if (left > right) {
            return;
        }
        int partitionIndex = partition(input, left, right, stringComparator);
        quickSort(input, left, partitionIndex - 1, stringComparator);
        quickSort(input, partitionIndex + 1, right, stringComparator);
    }

    /**
     * 分治思想
     *
     * @param input
     * @param left
     * @param right
     * @param stringComparator
     * @return
     */
    private static int partition(String[] input, int left, int right, StringComparator stringComparator) {
        String temp = input[left];
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && stringComparator.compare(input[i], temp) <= 0) i++;
            while (j >= left + 1 && stringComparator.compare(input[j], temp) >= 0) j--;
            if (i > j) {
                break;
            }
            Utils.swap(input, i, j);
            i++;
            j--;
        }
        Utils.swap(input, left, j);
        return j;
    }

    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new RuntimeException("args should not null");
            }
            int result = (o1 + o2).compareTo(o2 + o1);
            System.out.println("StringComparator left: "+o1+", right: "+o2+", ComparatorResult: "+result);
            return result;
        }
    }
}
