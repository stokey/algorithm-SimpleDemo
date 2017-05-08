package com.stokey.algorithmdemo.Algorithm.basic.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/7.
 */

public class InsertSort implements ISort {

    protected static <T extends Comparable<? super T>> void insertSort(T[] input) {
        if (input == null || input.length <= 0) {
            // TODO:input error
            return;
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j].compareTo(input[j - 1]) < 0) {
                    Utils.swap(input, j-1, j);
                } else {
                    break;
                }
            }
            // 优化写法
            /*
            for (int j = i; j > 0 && input[j].compareTo(input[j - 1]) > 0; j--) {
                Utils.swap(input, j-1, j);
            }*/
        }
    }

    protected static <T extends Comparable<? super T>> void insertSortAdvance(T[] input) {
        for (int i = 1; i < input.length; i++) {
            T temp = input[i];
            int j;
            for (j = i; j > 0 && (input[j - 1].compareTo(temp) > 0); j--) {
                // 往后移位
                input[j] = input[j - 1];
            }
            input[j] = temp;
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        insertSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) {
        insertSortAdvance(input);
    }
}
