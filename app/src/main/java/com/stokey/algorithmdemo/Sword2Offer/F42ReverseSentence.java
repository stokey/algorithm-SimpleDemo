package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by tiangen on 2017/6/6.
 */

public class F42ReverseSentence {
    /**
     * 输入一个英文句子，翻转句子中的单词顺序，但单词内字符顺序不变
     * 输入：I am a student. ===> 输出: student. a am I
     * 【栈结构】
     *
     * @param input
     * @return
     */
    public static String reverseSentence(String input) {
        if (input == null) {
            throw new RuntimeException("input error");
        }
        String[] inputArray = input.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < inputArray.length; i++) {
            stack.push(inputArray[i]);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    /**
     * 输入一个英文句子，翻转句子中的单词顺序，但单词内字符顺序不变
     * 输入：I am a student. ===> 输出: student. a am I
     * 【直接通过交换下标】
     *
     * @param input
     * @return
     */
    public static String reverseSentence2(String input) {
        if (input == null) {
            throw new RuntimeException("input error");
        }
        int len = input.length();
        char[] inputChar = input.toCharArray();
        reverse(inputChar, 0, len - 1);
        // 翻转单词
        int left = 0, right = 0;
        while (left < len) {
            ++right;
            if (right == len || inputChar[right] == ' ') {
                reverse(inputChar, left, right - 1);
                ++right;
                left = right;
            }
        }
        return new String(inputChar);
    }

    private static char[] reverse(char[] input, int i, int j) {
        if (input == null || input.length <= i || input.length <= j) {
            throw new RuntimeException("input error");
        }
        while (i < j) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            ++i;
            --j;
        }
        return input;
    }
}
