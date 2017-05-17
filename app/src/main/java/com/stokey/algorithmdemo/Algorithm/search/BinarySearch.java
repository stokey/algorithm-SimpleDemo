package com.stokey.algorithmdemo.Algorithm.search;

import com.stokey.algorithmdemo.Algorithm.basic.ISearch;

/**
 * Created by stokey on 2017/5/17.
 */

public class BinarySearch implements ISearch<Integer> {

    @Override
    public int search(Integer[] input, Integer target) {
        // TODO: confirm the input array is sorted
        int left = 0, right = input.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left / 2);//避免内存溢出
            if (input[mid].compareTo(target) == 0) {
                return mid;
            } else if (input[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public Integer searchObj(Integer[] input, Integer target) {
        // TODO: confirm the input array is sorted
        int left = 0, right = input.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left / 2);//避免内存溢出
            if (input[mid].compareTo(target) == 0) {
                return input[mid];
            } else if (input[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public int searchAdvance(Integer[] input, Integer target) {
        return -1;
    }

    @Override
    public Integer searchAdvanceObj(Integer[] input, Integer target) {
        return -1;
    }
}
