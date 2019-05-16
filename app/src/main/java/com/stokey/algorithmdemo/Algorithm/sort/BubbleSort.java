package com.stokey.algorithmdemo.Algorithm.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/7.
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */

public class BubbleSort implements ISort {

    protected <T extends Comparable<? super T>> void bubbleSort(T[] input) {
        for (int i = 0; i < input.length; i++) {
            int endIndex = input.length - i - 1;
            for (int j = 0; j <= endIndex; j++) {
                if (input[j].compareTo(input[j+1]) > 0) {
                    Utils.swap(input, j, j+1);
                }
            }
        }
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        bubbleSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {
        int n = input.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (input[i - 1].compareTo(input[i]) > 0) {
                    Utils.swap(input, i - 1, i);
                    swapped = true;
                }
                // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
                // 所以下一次排序, 最后的元素可以不再考虑
                n--;
            }
        } while (swapped);
    }
}
