package com.leetcode169.week7;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        if(s== null || s.length() <1) return "";

        int start =0, end =0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length palindrome
            /**
             * The length of the longest even-length palindromic substring centered between indices i and i + 1.
             * This is calculated by expanding around the center between i and i + 1 in the input string {@code s}.
             */
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
        
    }


    /**
     * Expands around the given center indices to find the length of the longest palindromic substring.
     *
     * @param s the input string to search for palindromic substrings
     * @param left the starting left index of the center
     * @param right the starting right index of the center
     * @return the length of the longest palindromic substring centered at the given indices
     */
    public int expandAroundCenter(String s, int left, int right) {
        if(s == null || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }
}
