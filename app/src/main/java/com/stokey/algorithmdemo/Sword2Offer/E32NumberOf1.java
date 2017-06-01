package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/31.
 */

public class E32NumberOf1 {
    /**
     * 从1到n整数中1出现的次数
     * <p>
     * N = 123
     * 出现次数 = 个位出现1的个数 + 十位出现1的个数 + 百位出现1的个数
     * 57    =  13 [1,11...91,101,111,121] + 20 [10...19,110...119] + 24 [100...123]
     * <p>
     * 百位上出现1的次数由三部分决定：
     * 1. 百位上的数字
     * 2. 百位以上的数字（千位及以上）
     * 3. 百位以下的数字（十位和个位）
     * <p>
     * 如果百位上的数字为0，则百位上出现的1的次数仅由最高位决定，比如12013
     * 百位出现1的情况有：100～199，1100～1199，2100～2199,...,11100～11199 共 1200个（12*100）
     * <p>
     * 如果百位上的数字大于1，则百位上出现的次数仅由最高位决定，比如12213
     * 百位出现1的情况有：100～199，1100～1199，2100～2199,...,12100～12199 共 1300个（(12+1)*100）
     * <p>
     * 如果百位上的数字等于1，则百位上出现的次数不仅受最高位影响，还受低位影响，比如12113
     * 百位出现1的情况有：100～199，1100～1199，2100～2199,...11100~11199 共 1200个
     * 受低位影响的情况有：12100~12113 共114个 （113+1）
     *
     * @param n
     * @return
     */
    public static long num(long n) {
        // TODO: 输入合法性检测
        long number = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;
            if (current > 1) {
                number = number + (before + 1) * i;
            } else if (current == 0) {
                number = number + before * i;
            } else if (current == 1) {
                number = number + before * i + after + 1;
            }
            i = i * 10;
        }
        return number;
    }
}
