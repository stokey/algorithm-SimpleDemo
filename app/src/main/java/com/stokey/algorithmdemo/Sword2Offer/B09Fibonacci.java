package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B09Fibonacci {

    /**
     * 【无法获得offer】
     * 最原始的递归，有严重的效率问题
     * f(10) = f(9)+f(8)
     * f(9) = f(8)+f(7)
     * 存在多次重复计算
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 改进后，时间复杂度O(n)
     * @param n
     * @return
     */
    public static long fibonacciAdvance1(int n) {
        // 存放需要f(n-1),f(n-2)的值
        long[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long fibOne = result[0];
        long fibTwo = result[1];
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

    /**
     * 最优解，时间复杂度O(logn)
     * 使用到矩阵
     * @param n
     * @return
     */
    public long fibonacciAdvance2(int n){
        // 未实现
        if(n <= 0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        return -1;
    }
}
