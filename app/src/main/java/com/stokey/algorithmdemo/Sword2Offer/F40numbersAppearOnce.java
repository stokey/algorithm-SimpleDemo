package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/6.
 */

public class F40numbersAppearOnce {

    /**
     * 数组中只出现一次的数字【一个整型数组除了两个数字之外，其他的数字都出现了两次，求出这两个只出现一次的数字】
     * 【时间复杂度O(n),空间复杂度O(1)】
     * 解法：二进制位运算（相同数字的异或操作等于0）
     * 将数组中的数字异或操作之后：num1 ^ num2
     * 异或结果二进制中肯定有移位等于1【根据等于1的位置，将原数组划分成两个不同数组。最后对两个数组分别进行异或操作，得出结果】
     *
     * @param input
     * @return
     */
    public static int[] showOnce(int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("input error");
        }
        int[] result = new int[2];
        int xor = 0;
        for (int temp : input) {
            xor ^= temp;
        }
        int indexOf1 = findFirstBitIs1(xor);

        for (int temp : input) {
            if (isBit1(temp, indexOf1)) {
                result[0] ^= temp;
            } else {
                result[1] ^= temp;
            }
        }
        return result;
    }

    /**
     * 判断数字temp的二进制表示中倒数indexOf1位置是否等于1
     * @param temp
     * @param indexOf1
     * @return
     */
    private static boolean isBit1(int temp, int indexOf1) {
        temp >>= indexOf1;
        return (temp & 1) == 1;
    }

    /**
     * 返回xor的二进制表示中，第一个1出现在倒数第几位
     *
     * @param xor
     * @return
     */
    private static int findFirstBitIs1(int xor) {
        int index = 0;
        while (index < 32 && (xor & 1) == 0) {
            index++;
            xor >>= 1;
        }
        return index;
    }

}
