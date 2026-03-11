package com.leetcode169.week16;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /**
     * Finds the minimum window substring in string s that contains all characters from string t.
     * Uses a sliding window approach with two pointers and a frequency map.
     * 
     * <p>Algorithm:
     * <ul>
     *   <li>Creates a frequency map of characters in string t</li>
     *   <li>Expands the window by moving right pointer until all characters are found</li>
     *   <li>Contracts the window by moving left pointer while maintaining all characters</li>
     *   <li>Tracks the minimum window that contains all required characters</li>
     * </ul>
     * 
     * <p>Time Complexity: O(m + n) where m is the length of s and n is the length of t
     * <br>Space Complexity: O(k) where k is the number of unique characters in t
     * 
     * @param s the source string to search within
     * @param t the target string containing characters to find
     * @return the minimum window substring that contains all characters from t,
     *         or an empty string if no such window exists
     * 
     * @example
     * minWindow("ADOBECODEBANC", "ABC") returns "BANC"
     * minWindow("a", "a") returns "a"
     * minWindow("a", "aa") returns ""
     */
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
