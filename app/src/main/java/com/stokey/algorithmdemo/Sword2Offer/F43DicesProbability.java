package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/6/6.
 */

public class F43DicesProbability {
    private static int MAX_VALUE = 6;

    /**
     * n个骰子扔在地上，素有骰子朝上一面的点数之和为S，打印所有S的可能的值和出现的概率
     * 递归解法：n + n-1
     * 【有大量重复计算，时间效率不高】
     *
     * @param number
     */
    public static void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * MAX_VALUE;
        int[] probabilities = new int[maxSum - number + 1];// 数组保存所有点数之和的情况，出现的次数

        // 第一个骰子的6种情况
        for (int i = 1; i <= MAX_VALUE; i++) {
            probability(number, number, i, probabilities);
        }

        printProbability(number, maxSum, probabilities);
    }

    /**
     * n个骰子扔在地上，素有骰子朝上一面的点数之和为S，打印所有S的可能的值和出现的概率
     * 循环解法：二维数组求解
     * probabilities[2][i]:
     * 第一行代表：第一堆的这个骰子 当前累加和的情况
     * 第二行表示：另外一堆的骰子（6种情况）[n-1 + last]，分别给上一堆的每种情况再加上（1，2，3，4，5，6）
     *
     * @param number
     */
    public static void printProbabilityAdvance(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * MAX_VALUE;
        int[][] probabilities = new int[2][maxSum - number + 1];
        // 初始化
        for (int i = 0; i <= maxSum; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        // 第一个骰子的6种情况
        for (int i = 1; i <= MAX_VALUE; i++) {
            probabilities[0][i] = 1;
        }
        // 开始抛剩下的骰子
        int flag = 0; // 标记哪一行被使用过

        for (int k = 2; k <= number; k++) {
            // 如果抛出了k个骰子，那么和为[0,k-1]的概率为0
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= MAX_VALUE * k; i++) {
                probabilities[1 - flag][i] = 0;
                // 统计和为i时的点数出现次数
                for (int j = 1; j <= i && j <= MAX_VALUE; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        printProbability(number, maxSum, probabilities, flag);
    }

    private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i++) {
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }

    /**
     * 打印概率
     *
     * @param number
     * @param maxSum
     * @param probabilities
     */
    private static void printProbability(int number, int maxSum, int[] probabilities) {
        double total = Math.pow(MAX_VALUE, number); //计算概率的分母
        for (int i = number; i <= maxSum; i++) {
            double ratio = probabilities[i - number] / total;
            System.out.print("P(" + i + ")=");
            System.out.printf("%.4f", ratio);
            if (i != maxSum) {
                System.out.print(", ");
            }
        }
    }

    /**
     * 打印概率
     *
     * @param n
     * @param maxSum
     * @param probabilities
     * @param flag
     */
    private static void printProbability(int n, int maxSum, int[][] probabilities, int flag) {
        double total = Math.pow(MAX_VALUE, n);
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[flag][i - n] / total;
            System.out.print("P(" + i + ")=");
            System.out.printf("%.4f", ratio);
            if (i != maxSum) {
                System.out.print(", ");
            }
        }
    }
}
