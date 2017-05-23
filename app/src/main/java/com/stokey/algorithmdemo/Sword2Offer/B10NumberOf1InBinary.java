package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/5/22.
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
        return input;
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
     *
     * @param input
     * @return
     */
    public static int get1NumsAdvance2(int input) {
        int count = 0;

        // n & (n-1) 表示将n的最右边位1变成0，左边不变，更右边0变成1
        // 10: 1100 & 9: 1011 ==> 6:1000
        while (input != 0) {
            ++count;
            input = (input) & (input - 1);
        }

        return count;
    }


    /**
     * 判断输入整数是否是2的整数次方
     * 【2的整数次方的二进制只有最高位为1，则(n & (n-1)=0】
     * @param input
     * @return
     */
    public static boolean isIntegerPowerOf2(int input){
        if (input ==0){
            return false;
        }
        return (input & (input-1)) == 0;
    }

    /**
     * 输入整数n,m,计算需要改变m的二进制表示中的多少为才能得到n
     * 【第一步求出两个数的异或，第二步统计异或结果中1的位数】
     * @param m
     * @param n
     * @return
     */
    public static int changeSteps(int m,int n){
        int temp = m ^ n; // 获取异或数值
        return get1NumsAdvance2(temp);
    }
}
