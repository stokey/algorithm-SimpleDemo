package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/7.
 */

public class F47AddTwoNumbers {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、✖️、/
     * 解法：通过二进制的位运算达到效果
     * 加法三步：
     * 5+17=22
     * 1. 只做各位相加不进位，此时相加结果12（个位5和7相加不进位是2，十位数0和1相加结果是1）
     * 2. 做进位，5+7中有进位，进位的值是10
     * 3. 把前面两个结果加起来，12+10结果是22
     * <p>
     * 二进制的加法运算用位运算替代：
     * 1. 不考虑进位，对每一位相加（异或）
     * 2. 进位，只有1加1时才会向前进位（两个数先做位与运算，然后再向左移动一位）
     * 3. 把前两个步骤的结果相加【依然重复前面两步，知道不产生进位为止】
     *
     * @param n
     * @param m
     * @return
     */
    public static int plus(int n, int m) {
        int sum, carry;
        do {
            sum = n ^ m;
            carry = (n & m) << 1;
            n = sum;
            m = carry;
        } while (m != 0);
        return n;
    }

    /**
     * 相关问题：不使用新的变量交换两个变量的值
     * 比如：交换a、b的值
     * <p>
     * 基于加减法：a = 2, b = 4
     * a = a + b;
     * b = a - b; // a-->b
     * a = a - b; // b-->a
     * <p>
     * 基于异或运算：a=2,b=4 [a^a=0, 0^x=x]
     * a = a ^ b;
     * b = a ^ b; // a^b^b=a
     * a = a ^ b;// a^b^a=b
     */
    public static void other() {
    }
}
