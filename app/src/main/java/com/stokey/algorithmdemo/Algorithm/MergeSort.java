package com.stokey.algorithmdemo.Algorithm;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;

import java.util.Arrays;

/**
 * Created by tiangen on 2017/5/8.
 */

public class MergeSort implements ISort {

    // 三个位置，i指向left开始位置，j指向right开始位置，k指向目标数组待填充位置下标

    protected <T extends Comparable<? super T>> void mergeSort(T[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    protected <T extends Comparable<? super T>> void mergeSortAdvance(T[] input) {
        mergeSortAdvance(input, 0, input.length - 1);
    }

    /**
     * 将[left...mid]与[mid+1...right]两部分进行合并
     *
     * @param input
     * @param left
     * @param mid
     * @param right
     * @param <T>
     */
    private <T extends Comparable<? super T>> void merge(T[] input, int left, int mid, int right) {
        T[] aux = Arrays.copyOfRange(input, left, right + 1);
        //初始化i指向left部分开始位置，j指向right开始部分——mid+1的位置
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // left部分已经合并完成
                input[k] = aux[j - left];
                j++;
            } else if (j > right) {
                // right部分已经合并完成
                input[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                input[k] = aux[i - left];
                i++;
            } else {
                input[k] = aux[j - left];
                j++;
            }
        }

    }

    /**
     * 自顶向下进行排序
     * 对[left...right]范围数组进行排序
     *
     * @param input
     * @param left
     * @param right
     * @param <T>
     */
    private <T extends Comparable<? super T>> void mergeSort(T[] input, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(input, left, mid);
            mergeSort(input, mid + 1, right);
            merge(input, left, mid, right);
        }
    }

    /**
     * 自底向上进行排序
     *
     * @param input
     * @param n
     * @param <T>
     */
    private <T extends Comparable<? super T>> void mergeBottomUp(T[] input, int n) {
        for (int sz = 1; sz <= n; sz *= 2) {
            for (int i = 0; i + sz < n; i += 2 * sz) {
                // 对[i...i+sz-1]和[i+sz...2*sz+i-1]进行合并
                merge(input, i, i + sz - 1, Math.min(2 * sz + i - 1, n - 1));
            }
        }
    }

    private <T extends Comparable<? super T>> void mergeSortAdvance(T[] input, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(input, left, mid);
            mergeSort(input, mid + 1, right);
            if (input[mid].compareTo(input[mid + 1]) > 0) {
                merge(input, left, mid, right);
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        mergeSort(input);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {
        mergeSortAdvance(input);
    }
}
