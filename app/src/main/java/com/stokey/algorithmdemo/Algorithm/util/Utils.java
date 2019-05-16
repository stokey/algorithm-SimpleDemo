package com.stokey.algorithmdemo.Algorithm.util;

import com.stokey.algorithmdemo.Algorithm.basic.ISort;

import java.util.Date;

/**
 * Created by stokey on 2017/5/7.
 */

public class Utils {

    public static <T> T[] swap(T[] input, int start, int end) {
        if (input == null || input.length < end || start > end || start < 0) {
            // TODO: input is error
            return null;
        }

        if (start == end) {
            return input;
        }

        T temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        return input;
    }

    public static <T> void printF(String tag, T[] input) {
        printF(tag, input, false);
    }

    public static <T> void printF(String tag, T[] input, boolean newLine) {
        if (input != null && input.length > 0) {
            StringBuilder printStr = new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                if (newLine) {
                    printStr.append(tag).append(": ").append(input[i]).append("\n");
                } else {
                    if (i == 0) {
                        printStr = new StringBuilder(tag + ": " + "[ " + input[i] + ",");
                    }

                    if (i == input.length - 1) {
                        printStr.append(input[i]).append(" ]");
                    }

                    if (i > 0 && i < input.length - 1) {
                        printStr.append(input[i]).append(",");
                    }
                }
            }
            System.out.println(printStr);
        }
    }

    private static <T> void printFCostTime(String tag, T[] input, long startTime, long endTime, boolean printItem) {
        if (printItem) {
            printF(tag, input, true);
        }
        System.out.println(tag + ": cost time = " + (endTime - startTime) + "ms");
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input) {
        sort(className, input, false);
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input, boolean print) {
        sort(className, input, print, false);
    }

    public static <T extends Comparable<? super T>> void sort(String className, T[] input, boolean print, boolean sortAdvance) {
        if (input == null || input.length <= 0) {
            // TODO: input error
            System.out.println("Error: input error");
        }
        long startTime = System.currentTimeMillis();
        try {
            Class<ISort> classTemp = (Class<ISort>) Class.forName(className);
            ISort temp = classTemp.newInstance();
            if (sortAdvance) {
                temp.sortAdvance(input);
            } else {
                temp.sort(input);
            }
            long endTime = System.currentTimeMillis();
            printFCostTime(className, input, startTime, endTime, print);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
