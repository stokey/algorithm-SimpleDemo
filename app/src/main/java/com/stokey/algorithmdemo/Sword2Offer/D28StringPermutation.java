package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/26.
 */

public class D28StringPermutation {

    /**
     * 字符串排列组合问题
     * @param str
     */
    public static void permutation(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        char[] input = str.toCharArray();
        char[] input2 = input.clone();
        StringBuilder output = new StringBuilder(input.length);
        combination(input, input.length, output, 0);

        System.out.println("====================================");

        combination(str);

        System.out.println("====================================");

        combinationStr(input2, 0);
    }

    /**
     * * 输入一个字符串，打印出该字符串中字符的所有组合
     * abc ---> a,ab,abc,ac,b,bc,c
     *
     * @param input
     * @param length
     * @param output
     * @param begin
     */
    private static void combination(char[] input, int length, StringBuilder output, int begin) {
        if (begin == length) {
            return;
        } else {
            for (int i = begin; i < length; i++) {
                output.append(input[i]);
                System.out.println(output.toString() + " ");
                combination(input, length, output, i + 1);
                output.deleteCharAt(output.length() - 1);
            }
        }
    }

    /**
     * * 输入一个字符串，打印出该字符串中字符的所有组合[ba,ab算是同一种组合不同排列]
     * abc ---> a,ab,abc,ac,b,bc,c
     * <p>
     * 位图解法思想：abc
     * 001,010,011,100,101,110,111 七种=2^3-1
     *
     * @param str
     */
    private static void combination(String str) {
        if (str.isEmpty()) {
            return;
        } else {
            char[] inputs = str.toCharArray();
            int length = inputs.length;
            int n = 1 << length;//(2^length)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < length; j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(inputs[j]);
                    }
                }
                System.out.println();
            }
        }
    }


    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列
     * abc ---> abc,acb,bac,bca,cab,cba
     *
     * @param input
     * @param start
     */
    private static void combinationStr(char[] input, int start) {
        if (input == null || input.length <= 0 || start < 0 || start >= input.length) {
            return;
        }

        if (start >= input.length) {
            return;
        } else if (start == input.length - 1) {
            System.out.println(String.valueOf(input));
        } else {
            for (int j = start; j < input.length; j++) {
                swap(input, j, start); // 交换
                combinationStr(input, start + 1);
                swap(input, j, start); // 恢复
            }
        }
    }

    private static void swap(char[] input, int i, int j) {
        if (input == null || input.length <= 0 ||
                input.length <= i || input.length <= j || i < 0 || j < 0) {
            return;
        }
        char temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}
