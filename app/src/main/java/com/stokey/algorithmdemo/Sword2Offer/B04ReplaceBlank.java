package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/21.
 */

public class B04ReplaceBlank {
    public static void main(String[] args) {
        String OriginalString = "We are happy";
        String replaceTag = "%20";
        System.out.println("origin String is:" + OriginalString + ", replaceTag is:" + replaceTag);

        char[] strCharArr = OriginalString.toCharArray();
        char[] result = replace(strCharArr, replaceTag);
        System.out.println(result != null && result.length > 0 ?
                "result:" + result.toString() : "result is null");
    }

    /**
     * 将空格替换成tag
     *
     * @param input
     * @param tag
     * @return
     */
    public static char[] replace(char[] input, String tag) {
        // TODO:检测输入合法性
        int tagSize = tag.length();
        if (input == null || tagSize <= 0) {
            return null;
        }
        char[] tagChar = tag.toCharArray();
        int length = input.length;
        int numberOfBlank = 0;

        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') {
                numberOfBlank++;
            }
        }

        int newLength = length + (tagSize - 1) * numberOfBlank;

        char[] result = new char[newLength];

        int endIndex = length - 1;
        int endResultIndex = newLength - 1;

        while (endIndex >= 0) {
            if (input[endIndex] == ' ') {
                for (int i = tagSize - 1; i >= 0; i--) {
                    result[endResultIndex] = tagChar[i];
                    endResultIndex--;
                }
            } else {
                result[endResultIndex] = input[endIndex];
                endResultIndex--;
            }
            endIndex--;
        }
        return result;
    }
}
