package com.stokey.algorithmdemo.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class NoRepeatString {
    public static void main(String[] args) {
        String test1 = "pwwkew";
        System.out.println("pwwkew max sub str is:" + NoRepeatString.lengthOfLongestSubstring(test1));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstringAdvance(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstringAdvance2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        for (; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
