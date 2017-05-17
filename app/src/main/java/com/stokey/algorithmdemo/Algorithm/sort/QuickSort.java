package com.stokey.algorithmdemo.Algorithm.sort;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;
import com.stokey.algorithmdemo.Algorithm.util.Utils;

import java.util.Random;

/**
 * Created by stokey on 2017/5/10.
 */

public class QuickSort implements ISort {

    /**
     * 快速排序
     * @param input
     * @param left
     * @param right
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void quickSort(T[] input, int left, int right) {
        if (left < right) {
            int p = partition(input, left, right);
            quickSort(input, left, p - 1);
            quickSort(input, p + 1, right);
        }
    }

    /**
     * 随机快速排序[减小对基本有序数组排序时时间复杂度为O(n^2)的概率]
     * @param input
     * @param left
     * @param right
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void quickSortAdvance(T[] input, int left, int right) {
        if (left < right) {
            int p = partitionAdvance(input, left, right);
            quickSortAdvance(input, left, p - 1);
            quickSortAdvance(input, p + 1, right);
        }
    }

    /**
     * 双路快速排序
     * @param input
     * @param left
     * @param right
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void quickSortAdvance2(T[] input, int left, int right) {
        if (left < right) {
            int p = partitionAdvance2(input, left, right);
            quickSortAdvance2(input, left, p - 1);
            quickSortAdvance2(input, p + 1, right);
        }
    }

    /**
     * 三路快速排序[处理拥有大量重复元素数组]
     * @param input
     * @param left
     * @param right
     * @param <T>
     */
    protected <T extends Comparable<? super T>> void quickSortAdvance3(T[] input, int left, int right) {
        // 减小在有序序列中时间复杂度为O(n^2)的概率
        Random random = new Random();
        int rnNum = random.nextInt(right - left + 1);
        Utils.swap(input, left, left + rnNum);

        // 取头部元素作为哨兵元素
        T temp = input[left];

        int lt=left;//[left+1...lt]<temp // 小于temp的最大下标
        int gt=right+1;//[gt...right]>temp // 大于temp的最小下标
        int i=left+1;//[left+1...i)===temp // 指针移动位置

        while (i<gt){
            if (input[i].compareTo(temp)<0){
                Utils.swap(input,i,++lt);
                i++;
            } else if(input[i].compareTo(temp)>0){
                Utils.swap(input,i,--gt);
            } else {
                i++;
            }
        }
        Utils.swap(input,left,lt);
        quickSortAdvance3(input,left,lt-1);
        quickSortAdvance3(input,gt,right);
    }


    private <T extends Comparable<? super T>> int partition(T[] input, int left, int right) {
        // 取头部元素作为哨兵元素
        T temp = input[left];
        // j表示 小于temp值的最大下标
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (input[i].compareTo(temp) < 0) {
                Utils.swap(input, ++j, i);
            }
        }
        // 最后将temp与小于temp值的最大下标位置值进行交换
        Utils.swap(input, left, j);
        return j;
    }

    /**
     * 随机分治法
     * @param input
     * @param left
     * @param right
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> int partitionAdvance(T[] input, int left, int right) {
        // 减小在有序序列中时间复杂度为O(n^2)的概率
        Random random = new Random();
        int rnNum = random.nextInt(right - left + 1);
        Utils.swap(input, left, left + rnNum);

        // 取头部元素作为哨兵元素
        T temp = input[left];
        // j表示 小于temp值的最大下标
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (input[i].compareTo(temp) < 0) {
                Utils.swap(input, ++j, i);
            }
        }
        // 最后将temp与小于temp值的最大下标位置值进行交换
        Utils.swap(input, left, j);
        return j;
    }

    /**
     * 双路分治法
     * @param input
     * @param left
     * @param right
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> int partitionAdvance2(T[] input, int left, int right) {
        // 减小在有序序列中时间复杂度为O(n^2)的概率
        Random random = new Random();
        int rnNum = random.nextInt(right - left + 1);
        Utils.swap(input, left, left + rnNum);

        // 取头部元素作为哨兵元素
        T temp = input[left];

        // [left+1...i]<=temp; [j...right]>=temp
        int i = left+1,j=right;

        while (true){
            while (i<=right && input[i].compareTo(temp) <=0) i++;
            while (j>=left+1 && input[j].compareTo(temp)>=0) j--;
            if(i>j) break;
            Utils.swap(input,i,j);
            i++;
            j--;
        }
        Utils.swap(input,left,j);
        return j;
    }


    @Override
    public <T extends Comparable<? super T>> void sort(T[] input) {
        quickSort(input, 0, input.length - 1);
    }

    @Override
    public <T extends Comparable<? super T>> void sortAdvance(T[] input) throws Exception {
        quickSortAdvance2(input,0,input.length-1);
    }
}
