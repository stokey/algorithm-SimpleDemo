package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by stokey on 2017/5/31.
 */

public class E31GreatestSumOfSubarrays {
    /**
     * 连续子数组的最大和
     *
     * @param input
     * @return
     */
    public static int find(int[] input) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input error");
        }

        int nCurSum = 0;
        int nGreatestSum = 0;
        for (int i = 0; i < input.length; i++) {
            if (nCurSum <= 0) {
                nCurSum = input[i];
            } else {
                nCurSum += input[i];
            }

            if (nCurSum > nGreatestSum) {
                nGreatestSum = nCurSum;
            }
        }
        return nGreatestSum;
    }
}
