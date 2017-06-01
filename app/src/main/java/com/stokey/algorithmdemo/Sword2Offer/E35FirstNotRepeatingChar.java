package com.stokey.algorithmdemo.Sword2Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stokey on 2017/6/2.
 */

public class E35FirstNotRepeatingChar {
    /**
     * 在字符串中找出第一个出现一次的字符
     * 【统计字符出现次数】
     *
     * @param input
     * @return
     */
    public static Character firstNotRp(char[] input) {
        if (input == null || input.length <= 0) {
            throw new RuntimeException("input error");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int num = 1;
            if (map.containsKey(input[i])) {
                num = map.get(input[i]) + 1;
            }
            map.put(input[i], num);
        }

        for (int j = 0; j < input.length; j++) {
            if (map.get(input[j]) == 1) {
                return input[j];
            }
        }
        return null;
    }
}
