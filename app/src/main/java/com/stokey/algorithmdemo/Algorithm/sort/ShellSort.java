package com.stokey.algorithmdemo.Algorithm.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;

/**
 * Created by stokey on 2017/5/7.
 */

public class ShellSort implements ISort {

    protected <T extends Comparable<? super T>> void shellSort(T[] input) {
        // 先把数据按照步长进行分组，然后对不同分组进行排序，直到步长长度为1
        int gap = input.length / 2;
        while (gap > 0) {
            // 将步长为gap的元素编为一个数组
            for (int i = gap; i < input.length; i++) {
                int j = i - gap;
                T temp = input[i];
                for (; j >= 0 && input[j].compareTo(temp) > 0; j -= gap) {
                    // 交换位置
                    input[i] = input[j];
                }
                input[j + gap] = temp;
            }
            gap /= 2;
        }

    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        shellSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {

    }
}
