package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 * 题目一：
 * 写一个函数，输入n，求斐波拉契数列的第n项
 */

public class B09Fibonacci {

    /**
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
     * 循环方式
     *
     * @param n
     * @return
     */
    public static long fibonacciAdvance1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // f(n-1)的值
        long fibOne = 1;
        // f(n-2)的值
        long fibTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }

    /**
     * 最优解，时间复杂度O(logn)
     * 使用到矩阵
     *
     * @param n
     * @return
     */
    public long fibonacciAdvance2(int n) {
        // TODO 未实现
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return -1;
    }

    /**
     * 一只青蛙可以跳1级台阶，也可以跳上2级台阶。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 分析：
     * 当n>2时，第一次跳有两种选择：
     * 一是第一次只跳一级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1)
     * 另外一种方式是第一次跳两级，此时跳法数目等于后面剩下的n-2级台阶的跳法数目，即为f(n-2)。
     * 因此n级台阶不同跳法：
     * f(n) = f(n-1) + f(n-2)
     *
     * @param step
     * @return
     */
    public static int frogump(int step) {
        if (step <= 0) {
            return 0;
        }
        if (step == 1) {
            return 1;
        }
        // f(n-1)
        int frogJumpOne = 1;
        // f(n-2)
        int frogJumpTwo = 0;
        int frogJumpN = 0;
        for (int i = 2; i <= step; i++) {
            frogJumpN = frogJumpOne + frogJumpTwo;
            frogJumpTwo = frogJumpOne;
            frogJumpOne = frogJumpN;
        }
        return frogJumpN;
    }
}

class B09Test {
    public static void main(String[] args) {
        System.out.println("0:" + B09Fibonacci.fibonacciAdvance1(0));
        System.out.println("1:" + B09Fibonacci.fibonacciAdvance1(1));
        System.out.println("4:" + B09Fibonacci.fibonacciAdvance1(4));
        System.out.println("5:" + B09Fibonacci.fibonacciAdvance1(5));
        System.out.println("6:" + B09Fibonacci.fibonacciAdvance1(6));

        System.out.println("frogJump Step 6:" + B09Fibonacci.frogump(6));
    }
}
