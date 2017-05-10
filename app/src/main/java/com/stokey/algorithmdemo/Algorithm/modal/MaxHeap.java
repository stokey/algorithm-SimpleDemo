package com.stokey.algorithmdemo.Algorithm.modal;

import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/11.
 */

public class MaxHeap<T extends Comparable<? super T>> {
    private int capacity;
    private int count;
    private T[] data;

    /**
     * 构造最大堆（数组首位元素为空）
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    private void shiftUp(int k) {
        while (k > 1 && this.data[k / 2].compareTo(this.data[k]) < 0) {
            Utils.swap(this.data, k / 2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && this.data[j + 1].compareTo(this.data[j]) > 0) {
                j++;
            }
            if (this.data[k].compareTo(this.data[j]) < 0) {
                Utils.swap(this.data, k, j);
                k = j;
            }
        }
    }

    /**
     * 插入元素
     *
     * @param data
     * @throws Exception
     */
    public void insert(T data) throws Exception {
        if (count < capacity) {
            // 首位元素为空，最大堆元素从下标1开始计数
            this.data[++count] = data;
            shiftUp(count);
        } else {
            throw new Exception("out of max size");
        }
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 取出最大元素
     *
     * @return
     */
    public T extractMax() {
        T result = null;
        if (!isEmpty() && count > 0) {
            result = data[1];
            //把最后元素放置到顶点
            Utils.swap(this.data, 1, count);
            count--;
            shiftDown(1);
        }
        return result;
    }
}
