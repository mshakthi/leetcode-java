package com.leetcode169.week16;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int start = -1;

        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (freq.containsKey(rChar)) {
                if (freq.get(rChar) > 0) {
                    count++;
                }
                freq.put(rChar, freq.getOrDefault(rChar, 0) - 1);
            }

            while (count == t.length()) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    start = left;
                }

                char lChar = s.charAt(left);
                if (freq.containsKey(lChar)) {
                    freq.put(lChar, freq.getOrDefault(lChar, 0) + 1);
                    if (freq.get(lChar) > 0) {
                        count--;
                    }
                }

                left++;
            }

            right++;

        }

        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLen);
    }
}
