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
        int start = 0, end = 0;
        while (start < len) {
            ++end;
            if (start == len || inputChar[start] == ' ') {
                reverse(inputChar, start, end - 1);
                ++end;
                start = end;
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

    /**
     * 字符串左旋转：把字符串前面的若干个字符转移到字符串的尾部
     * 【abcdefg + 2 ===> cdefgab】
     * 解法：把字符串看成两部分[0...num] + [num+1...size]
     * ===> [num...0] + [size...num+1] ===> [num+1...0...num]
     * { abcdefg ===>[ab][cdefg]===>[ba]+[gfedc]===>[cdefgab]}
     * @param input
     * @param num
     */
    public static String reverseLeft(char[] input, int num) {
        if (input == null || input.length < num || num <0) {
            throw new RuntimeException("input error");
        }
        int len = input.length;
        reverse(input,0,num-1);
        reverse(input,num,len-1);
        reverse(input,0,len-1);
        return new String(input);
    }
}
