package com.stokey.algorithmdemo.Algorithm.basic;

import java.util.Random;

/**
 * Created by stokey on 2017/5/7.
 */

public class GenerateData {

    public static Integer[] gen(int num, int range) {
        Integer[] result = new Integer[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int temp = random.nextInt(range);
            result[i] = temp;
        }
        return result;
    }
}
