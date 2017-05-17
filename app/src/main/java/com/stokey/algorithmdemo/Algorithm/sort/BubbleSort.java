package com.stokey.algorithmdemo.Algorithm.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/7.
 */

public class BubbleSort implements ISort {

    protected <T extends Comparable<? super T>> void bubbleSort(T[] input) {
        for (int i = 0; i < input.length; i++) {
            int maxIndex = 0;
            int endIndex = input.length - i;
            for (int j = 1; j < endIndex; j++) {
                if (input[j].compareTo(input[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            Utils.swap(input, maxIndex, endIndex-1);
        }
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        bubbleSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {

    }
}
