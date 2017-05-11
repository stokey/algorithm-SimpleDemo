package com.stokey.algorithmdemo.Algorithm;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.modal.MaxHeap;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/11.
 */

public class HeapSort implements ISort {

    /**
     * 通过堆化操作构建最大堆,然后出栈获取最大值，直至结束
     *
     * @param input
     * @param n
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void heapSort(T[] input, int n) {

        MaxHeap<T> heap = new MaxHeap<>(input, n);
        for (int i = n - 1; i > 0; i--) {
            input[i] = heap.extractMax();
        }
    }

    /**
     * 通过插入操作构建最大堆，然后出栈获取最大值，直至结束
     *
     * @param input
     * @param n
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void heapSort1(T[] input, int n) {

        MaxHeap<T> heap = new MaxHeap<>(n);
        for (int j = 0; j < n; j++) {
            try {
                heap.insert(input[j]);
            } catch (Exception e) {
                System.out.println("max heap insert error:" + e.getMessage());
                return;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            input[i] = heap.extractMax();
        }
    }

    /**
     * 通过堆化操作构建最大堆（原地堆排序）
     *
     * @param input
     * @param n
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void heapSortAdvance(T[] input, int n) {
        // heapify堆化操作
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(input, n, i);
        }
        for (int k = n - 1; k > 0; k--) {
            Utils.swap(input, 0, k);
            shiftDown(input, k, 0);
        }
    }

    private <T extends Comparable<? super T>> void shiftDown(T[] input, int n, int k) {
        while (2*k+1 <= n){
            int j = 2*k+1;
            if (j+1<n &&  input[j].compareTo(input[j+1])<0){
                j++;
            }

            if (input[k].compareTo(input[j])<0){
                Utils.swap(input,k,j);
                k = j;
            } else{
                break;
            }
        }
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        heapSort(input, input.length);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {
        heapSortAdvance(input, input.length);
    }
}
