package com.stokey.algorithmdemo.Algorithm.modal;

import com.stokey.algorithmdemo.Algorithm.util.Utils;

/**
 * Created by stokey on 2017/5/11.
 */

public class IndexMaxHeap<T extends Comparable<? super T>> {
    private int capacity;
    private int count;
    private T[] data;
    private Integer[] indexes;
    private Integer[] reverses;//index索引值在数组中的位置

    /**
     * 构造最大堆（数组首位元素为空）
     * O(nlogn)
     *
     * @param capacity
     */
    public IndexMaxHeap(int capacity) {
        this.data = (T[]) new Object[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
        this.indexes = new Integer[capacity + 1];
        this.reverses = new Integer[capacity + 1];
        for (int i = 0; i < this.reverses.length; i++) {
            this.reverses[i] = 0;
        }
    }

    /**
     * 构造最大堆O(n)
     *
     * @param array
     * @param n
     */
    public IndexMaxHeap(T[] array, int n) {
        this.data = (T[]) new Object[n + 1];
        this.capacity = n;
        this.indexes = new Integer[n + 1];
        for (int i = 0; i < n; i++) {
            this.data[i + 1] = array[i];
        }
        this.reverses = new Integer[capacity + 1];
        for (int i = 0; i < this.reverses.length; i++) {
            this.reverses[i] = 0;
        }
        this.count = n;

        for (int k = n / 2; k >= 1; k--) {
            shiftDown(k);
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && this.data[indexes[k / 2]]
                .compareTo(this.data[indexes[k]]) < 0) {
            Utils.swap(this.indexes, k / 2, k);
            reverses[k / 2] = k / 2;
            reverses[k] = k;
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && this.data[indexes[j + 1]]
                    .compareTo(this.data[indexes[j]]) > 0) {
                j++;
            }
            if (this.data[indexes[k]].compareTo(this.data[indexes[j]]) < 0) {
                Utils.swap(this.indexes, k, j);
                reverses[this.indexes[k]] = k;
                reverses[this.indexes[j]] = j;
                k = j;
            } else {
                break;
            }
        }
    }

    /**
     * 插入元素
     *
     * @param index 插入索引[外部从零开始，内部从1开始计数]
     * @param data  待插入元素
     * @throws Exception
     */
    public void insert(int index, T data) throws Exception {
        if (count < capacity && index < capacity && index >= 0) {
            index++;
            // 首位元素为空，最大堆元素从下标1开始计数
            this.data[index] = data;
            indexes[++count] = index;
            reverses[index] = count;
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
            result = data[indexes[1]];
            //把最后元素放置到顶点
            Utils.swap(this.indexes, 1, count);
            reverses[this.indexes[1]] = 1;
            reverses[this.indexes[count]] = 0;
            count--;
            shiftDown(1);
        }
        return result;
    }

    /**
     * 取出最大值元素的索引号
     *
     * @return
     */
    public Integer extractMaxIndex() {
        Integer result = 0;
        if (!isEmpty() && count > 0) {
            result = indexes[1] - 1;
            //把最后元素放置到顶点
            Utils.swap(this.indexes, 1, count);
            reverses[this.indexes[1]] = 1;
            reverses[this.indexes[count]] = 0;
            count--;
            shiftDown(1);
        }
        return result;
    }

    public T getItem(int index) {
        assert (contain(index));
        return index < this.count && index >= 0 ? data[index + 1] : null;
    }

    /**
     * 根据索引号替换元素值
     *
     * @param index
     * @param value
     */
    public void change(int index, T value) {
        assert (contain(index));
        index++;
        data[index] = value;
        // 找到data[index]在堆中的位置(this.indexes[j]==index,j表示data[index]在最终位置)
        // ，然后进行shiftDown/shiftUp操作
//        for (int j = 1; j <= count; j++) {
//            if (this.indexes[j] == index) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }
        int j = this.reverses[index];
        shiftUp(j);
        shiftDown(j);

    }

    /**
     * 判断下标为index的元素是否在堆中
     *
     * @param i
     * @return
     */
    private boolean contain(int i) {
        return i >= 0 && i <= this.capacity && this.reverses[i + 1] != 0;
    }
}
