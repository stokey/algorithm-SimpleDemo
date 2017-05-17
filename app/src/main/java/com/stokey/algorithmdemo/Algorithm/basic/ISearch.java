package com.stokey.algorithmdemo.Algorithm.basic;

/**
 * Created by stokey on 2017/5/17.
 */

public interface ISearch<T> {
    int search(T[] input, T target);

    T searchObj(T[] input, T target);

    int searchAdvance(T[] input, T target);

    T searchAdvanceObj(T[] input, T target);
}
