package com.stokey.algorithmdemo.Algorithm.basic.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/7.
 */

public class SelectionSort implements ISort {

    protected <T> void selectionSort(T[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (((Comparable<T>) input[minIndex]).compareTo(input[j]) > 0) {
                    minIndex = j;
                }
            }
            Utils.swap(input, i, minIndex);
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        selectionSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {
        throw new Exception("not defined");
    }
}
