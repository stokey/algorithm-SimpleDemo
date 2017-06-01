package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/1.
 */

public class E34UglyNumber {
    /**
     * 把只包含因子2，3和5的数称作丑数（习惯上把1当作丑数）
     *
     * 寻找丑数构建方式
     * 一个丑数 = 另一个丑数 * 2／3／5（1除外）
     *【需要确保数组里面的丑数是已经排好序的——每次插入数组的都是最小的丑数】
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            throw new RuntimeException("input error");
        }
        int[] result = new int[index];
        result[0] = 1;
        int nextIndex = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        while (nextIndex < index) {
            int min = min(result[p2] * 2, result[p3] * 3, result[p5] * 5);
            result[nextIndex] = min;
            while (result[p2] * 2 <= result[nextIndex]) {
                ++p2;
            }
            while (result[p3] * 3 <= result[nextIndex]){
                ++p3;
            }
            while (result[p5] * 5 <= result[nextIndex]){
                ++p5;
            }
            ++nextIndex;
        }
        return result[nextIndex-1];
    }

    private static int min(int i, int i1, int i2) {
        int min = i;
        if (i1 < min) {
            min = i1;
        }
        if (i2 < min) {
            min = i2;
        }
        return min;
    }

    /**
     * 判断是否是丑数
     *
     * @param num
     * @return
     */
    private static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
