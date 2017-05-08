package com.stokey.algorithmdemo.Algorithm;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/7.
 */

public class BubbleSort implements ISort {

    private <T extends Comparable<? super T>> void bubbelSort(T[] input) {
        if (input == null || input.length <= 0) {
            // TODO: input is error
            return;
        }

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
        bubbelSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {

    }
}
