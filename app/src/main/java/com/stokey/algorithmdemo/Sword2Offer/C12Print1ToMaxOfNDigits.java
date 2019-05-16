package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/23.
 */

public class C12Print1ToMaxOfNDigits {
    /**
     * 打印1到最大的n位数【需要考虑大数问题——数组／字符串】
     * 在字符串上模拟数字加法
     *
     * @param max
     */
    public static void printNum(int max) {
        if (max <= 0) {
            throw new RuntimeException("input error:max must large 0");
        }
        char[] numsArray = new char[max];
        for (int i = 0; i < max; i++) {
            numsArray[i] = '0';
        }
        while (!increment(numsArray)) {
            printNumber(numsArray);
        }
    }

    private static boolean increment(char[] numsArray) {
        // 是否超出范围
        boolean isOverFlow = false;
        // 进位
        int takeOver = 0;
        // 长度
        int maxIndex = numsArray.length - 1;
        for (int i = maxIndex; i >= 0; i--) {
            int sum = numsArray[i] - '0' + takeOver;
            if (i == maxIndex) {
                sum++;
            }
            if (sum >= 10) {
                // 超出范围
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    numsArray[i] = (char) ('0' + sum);
                }
            } else {
                numsArray[i] = (char) ('0' + sum);
                break;
            }
        }
        return isOverFlow;
    }


    /**
     * n位所有十进制数其实就是n个从0到9的全排列
     * 把数字每一位都从0到9排序一遍即可
     * TODO 优化：8个bit的char型字符最多能表示256个字符，而十进制数字只有0~9的10个数。（short替代char）
     *
     * @param max
     */
    public static void printNumAdvance(int max) {
        if (max <= 0) {
            throw new RuntimeException("input error:max must large 0");
        }
        char[] numsArray = new char[max];
        for (int i = 0; i < 10; i++) {
            numsArray[0] = (char) (i + '0');
            print1ToMaxOfDigitsRecursively(numsArray, max, 0);
        }
    }

    private static void print1ToMaxOfDigitsRecursively(char[] numsArray, int length, int index) {
        if (index == length - 1) {
            printNumber(numsArray);
            return;
        }
        int nextIndex = index + 1;
        for (int i = 0; i < 10; i++) {
            numsArray[nextIndex] = (char) (i + '0');
            print1ToMaxOfDigitsRecursively(numsArray, length, nextIndex);
        }
    }

    /**
     * 从第一个非0位置开始打印数字
     *
     * @param numsArray
     */
    private static void printNumber(char[] numsArray) {
        boolean isBeginning = false;
        for (int i = 0; i < numsArray.length; i++) {
            if (!isBeginning && numsArray[i] != '0') {
                isBeginning = true;
            }

            if (isBeginning) {
                System.out.print(numsArray[i]);
            }
        }
        System.out.println();
    }

    /**
     * 定义一个函数，在该函数中可以实现任意两个整数的加法。
     * 由于没有限定输入数的大小，需要当做大数问题来处理。
     * TODO 如果有负数怎么处理？
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String increment(int num1, int num2) {
        char[] num1CharArray = String.valueOf(num1).toCharArray();
        char[] num2CharArray = String.valueOf(num2).toCharArray();

        int minLength = Math.min(num1CharArray.length, num2CharArray.length);
        int maxLength = Math.max(num1CharArray.length, num2CharArray.length);
        int resultLength = maxLength + 1;
        char[] result = new char[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = '0';
        }

        for (int i = 0; i < minLength; i++) {
            int plusNum = result[resultLength - 1 - i] - '0' + num1CharArray[num1CharArray.length - i - 1] - '0' + num2CharArray[num2CharArray.length - i - 1] - '0';
            if (plusNum >= 10) {
                result[resultLength - 1 - i] = (char) (plusNum - 10 + '0');
                result[resultLength - i - 2] += 1;
            } else {
                result[resultLength - 1 - i] = (char) (plusNum + '0');
            }
        }
        for (int j = minLength; j < maxLength; j++) {
            int currentIndexValue;
            if (maxLength == num1CharArray.length) {
                currentIndexValue = num1CharArray[maxLength - 1 - j] - '0';
            } else {
                currentIndexValue = num2CharArray[maxLength - 1 - j] - '0';
            }
            int plusNum = result[resultLength - 1 - j] - '0' + currentIndexValue;
            if (plusNum >= 10) {
                result[resultLength - 1 - j] = (char) (plusNum - 10 + '0');
                result[resultLength - j - 2] += 1;
            } else {
                result[resultLength - 1 - j] = (char) (plusNum + '0');
            }
        }
        if (result[0] == '0' || result[0] == ' ') {
            return String.valueOf(result).substring(1, result.length);
        }
        return String.valueOf(result);
    }
}

class C12Test {
    public static void main(String[] args) {
        C12Print1ToMaxOfNDigits.printNum(1);
        System.out.println("==============");
        C12Print1ToMaxOfNDigits.printNumAdvance(1);
        System.out.println("==============");
        System.out.println("123+12:" + C12Print1ToMaxOfNDigits.increment(123, 12));
        System.out.println("199+11:" + C12Print1ToMaxOfNDigits.increment(199, 11));
        System.out.println("Integer.MAX_VALUE+11:" + C12Print1ToMaxOfNDigits.increment(Integer.MAX_VALUE, 11));
    }
}
