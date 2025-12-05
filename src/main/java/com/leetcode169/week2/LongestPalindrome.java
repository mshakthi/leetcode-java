package com.leetcode169.week2;

import java.util.HashMap;

/**
 * Solution for finding the length of the longest palindrome that can be built with given characters.
 * 
 * This class implements an algorithm to determine the maximum length of a palindrome string
 * that can be constructed using the characters from the input string. Characters can be
 * rearranged in any order.
 * 
 * Algorithm:
 * 1. Count the frequency of each character in the input string
 * 2. For characters with even counts, all occurrences can be used
 * 3. For characters with odd counts, use (count - 1) occurrences
 * 4. If any character has an odd count, one additional character can be placed in the center
 * 
 * Time Complexity: O(n) where n is the length of the input string
 * Space Complexity: O(k) where k is the number of distinct characters
 * 
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        boolean odd = false;
        int length = 0;
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                odd = true; 
            }
        }

        return odd ? length + 1 : length;
        
    }
    
}
