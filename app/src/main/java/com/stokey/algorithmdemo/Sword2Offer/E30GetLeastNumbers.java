package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/31.
 */

public class E30GetLeastNumbers {

    /**
     * 最小的k个数
     * <p>
     * 分治思想，时间复杂度O(n)，会改变原始数组
     *
     * @param input
     * @param k
     * @return
     */
    public static int[] least(int[] input, int k) {
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            throw new RuntimeException("input error");
        }
        int[] output = new int[k];

        int index = partition(input, 0, input.length - 1);

        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(input, 0, index - 1);
            } else {
                index = partition(input, index + 1, input.length - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            output[i] = input[i];
        }
        return output;
    }

    /**
     * 最小的k个数
     * <p>
     * 通过构建"最大堆"求解：时间复杂度O(nlogk)，适合海量数据
     *
     * @param input
     * @param k
     * @return
     */
    public static int[] least2(int[] input, int k) {
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            throw new RuntimeException("input error");
        }
        int[] output = new int[k+1];
        for (int i = 0; i < k; i++) {
            output[i+1] = input[i];
        }

        // 建立最大堆
        heapify(output);

        for (int j = k; j < input.length; j++) {
            if (input[j] < output[1]) {
                output[1] = input[j];
                shiftDown(output, 1, k);
            }
        }
        int[] result = new int[k];
        // 去除0号元素
        for (int i = 0; i < k; i++) {
            result[i] = output[i + 1];
        }
        return result;
    }

    /**
     * 自底向上，通过shitDown操作调整数组为最大堆结构
     * 从右向左，从第一个含有子节点的非叶子节点进行调整
     *
     * @param output
     */
    private static void heapify(int[] output) {
        if (output == null || output.length <= 0) {
            return;
        }
        int count = output.length;
        int parentLeafCount = count / 2;
        for (int k = parentLeafCount; k > 0; k--) {
            shiftDown(output, k, count);
        }
    }

    private static void shiftDown(int[] input, int k, int size) {
        int parent = input[k];
        int childLeft = 2 * k;
        int childRight = childLeft + 1;

        int maxNumIndex = k;
        if (childLeft <= size) {
            maxNumIndex = childLeft;
        }
        if (childRight <= size) {
            if (input[maxNumIndex] < input[childRight]) {
                maxNumIndex = childRight;
            }
        }

        if (input[maxNumIndex] < parent) {
            swap(input, maxNumIndex, k);
        }
    }

    private static void shifDown2(int[] input, int k, int size) {
        while (2 * k <= size) {
            int child = 2 * k;
            if ( child + 1 <= size && input[child + 1] < input[child]) {
                child += 1;
            }
            if (input[k] >= input[child]) {
                break;
            }
            swap(input, child, k);
            k = child;
        }
    }

    /**
     * 分治思想
     *
     * @param input
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] input, int left, int right) {
        if (input == null || input.length <= 0 || left < 0 || left >= right) {
            throw new RuntimeException("partition input error");
        }
        int temp = input[left];
        int i = left + 1, j = right;
        while (i > j) {
            while (i <= right && input[i] <= temp) {
                i++;
            }
            while (j >= left + 1 && input[j] >= temp) {
                j--;
            }

            if (i > j) {
                break;
            }
            swap(input, i, j);
            i++;
            j--;
        }
        swap(input, left, j);
        return j;
    }

    private static void swap(int[] input, int i, int j) {
        if (input == null || input.length <= i || input.length <= j || i < 0 || j < 0) {
            return;
        }
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}
