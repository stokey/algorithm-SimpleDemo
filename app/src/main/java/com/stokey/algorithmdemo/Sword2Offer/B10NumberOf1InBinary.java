package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/22.
 * 位运算：
 * 1. 与
 * 2. 或
 * 3. 异或
 * 4. 左移：m<<n，表示把m左移n位。左移n位的时候，最左边的n位将被丢弃，同时在最右边补上n个0
 * 5. 右移：m>>n，表示把m右移n位。右移n位的时候，最右边的n位将被丢弃。但是右移时处理最左边位的情况要稍微复杂一点。
 * 如果数字是无符号数值，则用0调补最左边的n位。如果数字是一个有符号数值，则用数字的符号位调补最左边的n位（即：原来是正数，则用0填补。如果原来是负数，则用1填补）
 */

public class B10NumberOf1InBinary {

    /**
     * 获取输入整数二进制中1存在的个数
     * 输入数字不断右移，右移后的数据与1取&
     * 【该方法为考虑：负数——负数右移并不是简单地把最高位的1移动到第二位】
     * 【负数右移会造成0xFFFFFFFF陷入死循环】
     *
     * @param input
     * @return
     */
    public static int get1Nums(int input) {
        int count = 0;
        while (input != 0) {
            if ((input & 1) != 0) {
                ++count;
            }
            input >>= 1;
        }
        return count;
    }

    /**
     * 获取输入整数二进制中1存在的个数
     * 待判断数字不断右移[等价输入数字不断左移操作]，待判断数字右移之后与输入数字取&
     * 【避免输入负数造成的死循环操作】
     *
     * @param input
     * @return
     */
    public static int get1NumsAdvance1(int input) {
        int count = 0;
        int flag = 1;

        while (flag <= input) {

            if ((input & flag) != 0) {
                ++count;
            }

            flag <<= 1;
        }
        return count;
    }

    /**
     * 获取输入整数二进制中1存在的个数
     * 把一个整数二进制值减去1，再和原来整数做与运算，会把该整数最右边一个1变成0.
     * 1100 & 1011 == 1000
     * n & (n-1) 表示将n的最右边位1变成0
     *
     * @param input
     * @return
     */
    public static int get1NumsAdvance2(int input) {
        int count = 0;
        while (input != 0) {
            ++count;
            input = (input) & (input - 1);
        }
        return count;
    }


    /**
     * 判断输入整数是否是2的整数次方
     * 【2的整数次方的二进制只有最高位为1，则(n & (n-1)=0】
     *
     * @param input
     * @return
     */
    public static boolean isIntegerPowerOf2(int input) {
        if (input == 0) {
            return false;
        }
        return (input & (input - 1)) == 0;
    }

    /**
     * 输入整数n,m,计算需要改变m的二进制表示中的多少为才能得到n
     * 【第一步求出两个数的异或，第二步统计异或结果中1的位数】
     *
     * @param m
     * @param n
     * @return
     */
    public static int changeSteps(int m, int n) {
        // 获取异或数值
        int temp = m ^ n;
        return get1NumsAdvance2(temp);
    }

    /**
     * 在Excel 2003中，用A表示第一列，B表示第二列......Z表示第二26列，
     * AA表示第27列，AB表示28列，以此类推。请写出一个函数，输入字母表示的序列编号，输出它是第几列
     * 分析：
     * 本质上是十进制数字用A~Z表示成二十六进制
     *
     * @param input
     * @return
     */
    public static int convertNumber(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        char[] inputArray = input.toLowerCase().toCharArray();
        int result = 0;
        for (int i = 0; i < inputArray.length; i++) {
            int position = inputArray.length - i - 2;
            if (position < 0) {
                result += getNumByChar(inputArray[i]);
            } else {
                result += getNumByChar(inputArray[i]) * 26 * Math.pow(10, position);
            }
        }
        return result;
    }

    private static int getNumByChar(char ch) {
        switch (ch) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
            case 'i':
                return 9;
            case 'j':
                return 10;
            case 'k':
                return 11;
            case 'l':
                return 12;
            case 'm':
                return 13;
            case 'n':
                return 14;
            case 'o':
                return 15;
            case 'p':
                return 16;
            case 'q':
                return 17;
            case 'r':
                return 18;
            case 's':
                return 19;
            case 't':
                return 20;
            case 'u':
                return 21;
            case 'v':
                return 22;
            case 'w':
                return 23;
            case 'x':
                return 24;
            case 'y':
                return 25;
            case 'z':
                return 26;
            default:
                break;
        }
        return 0;
    }
}

class B10Test {
    public static void main(String[] args) {
        System.out.println("8 get 1:" + B10NumberOf1InBinary.get1Nums(8));
        System.out.println("9 get 1:" + B10NumberOf1InBinary.get1Nums(9));

        System.out.println("AA convert numbers:" + B10NumberOf1InBinary.convertNumber("AA"));
        System.out.println("D convert numbers:" + B10NumberOf1InBinary.convertNumber("D"));
        System.out.println("Ba convert numbers:" + B10NumberOf1InBinary.convertNumber("Ba"));

        System.out.println("16 isIntegerPowerOf2 " + B10NumberOf1InBinary.isIntegerPowerOf2(16));
        System.out.println("9 isIntegerPowerOf2 " + B10NumberOf1InBinary.isIntegerPowerOf2(9));

        System.out.println("10 change " + B10NumberOf1InBinary.changeSteps(10, 13) + " steps to 13");

        System.out.println("10 change " + B10NumberOf1InBinary.changeSteps(10, 10) + " steps to 10");
    }
}
