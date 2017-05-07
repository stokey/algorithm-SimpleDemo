package com.stokey.algorithmdemo.Algorithm.basic;

/**
 * Created by stokey on 2017/5/7.
 */

public interface ISort {
    <T extends Comparable<? super T>> void sort(T[] input);
    <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception;
}
