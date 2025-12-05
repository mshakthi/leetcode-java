package com.leetcode169.week4;

import java.util.HashMap;

public class LongestSubstring {
    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window approach with a HashMap to track character positions.
     *
     * @param s the input string to search for the longest substring without repeating characters
     * @return the length of the longest substring without repeating characters, or 0 if the string is empty
     * 
     * @implNote This method uses a HashMap to store the most recent index of each character encountered.
     *           The sliding window is adjusted by moving the left pointer forward when a duplicate is found,
     *           ensuring the window always contains unique characters.
     * 
     * @complexity Time: O(n) where n is the length of the string, as we iterate through it once
     *             Space: O(min(m, n)) where m is the character set size and n is the string length
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    } 
}
