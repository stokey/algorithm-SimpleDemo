package com.stokey.algorithmdemo.Algorithm;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;

/**
 * Created by tiangen on 2017/5/8.
 */

public class MergeSort implements ISort {
    protected <T extends Comparable<? super T>> void mergeSort(T[] input) {
        mergeSort(input,0,input.length-1);
    }

    private <T extends Comparable<? super T>> void merge(T[] input,int left,int center,int right){
        
    }

    private <T extends Comparable<? super T>> void mergeSort(T[] input,int left,int right){
        if (left < right){
            int center = (left+right)/2;
            mergeSort(input,left,center);
            mergeSort(input,center+1,right);
            merge(input,left,center,right);
        }
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        mergeSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {

    }
}
