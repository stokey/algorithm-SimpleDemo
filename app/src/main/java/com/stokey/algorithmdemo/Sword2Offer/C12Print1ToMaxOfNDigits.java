package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C12Print1ToMaxOfNDigits {
    /**
     * 打印1到最大的n位数【需要考虑大数问题——数组／字符串】
     *
     * @param max
     */
    public static void printNum(int max) {
        if (max <= 0) {
            throw new RuntimeException("input error:max must large 0");
        }
        int[] numsArray = new int[max + 1];

        while (addOne(numsArray)) {
            printNumber(numsArray);
        }
    }

    private static boolean addOne(int[] numsArray) {
        int carry = 1; // 进位值
        int index = numsArray.length - 1;//最低位
        while (carry != 0 && index > 0) {
            numsArray[index] += carry;
            carry = numsArray[index] / 10;
            numsArray[index] %= 10;
            index--;
        }
        if (carry > 0 && index == 0) {
            return false;
        }
        return true;
    }


    public static void printNumAdvance(int max) {
        if (max <= 0) {
            throw new RuntimeException("input error:max must large 0");
        }
        int[] numsArray = new int[max];
        for (int i = 0; i < max; i++) {
            numsArray[i] = 0;
        }
        print1ToMaxOfDigits2(0, numsArray);
    }

    private static void print1ToMaxOfDigits2(int i, int[] numsArray) {
        if (i == numsArray.length) {
            printNumber(numsArray);
            return;
        }
        for (int j = 0; j < 10; j++) {
            numsArray[i] = j;
            print1ToMaxOfDigits2(i + 1, numsArray);
        }
    }

    /**
     * 从第一个非0位置开始打印数字
     *
     * @param numsArray
     */
    private static void printNumber(int[] numsArray) {
        boolean isBeginning = false;
        for (int i = 0; i < numsArray.length; i++) {
            if (!isBeginning && numsArray[i] != 0) {
                isBeginning = true;
            }

            if (isBeginning) {
                System.out.print(numsArray[i] + " ");
            }
        }
        System.out.println();
    }
}
