package com.leetcode169.week3;

public class PalindromeNumber {
        /**
         * Checks if a given integer is a palindrome.
         * <p>
         * An integer is a palindrome when it reads the same backward as forward.
         * Negative numbers are not considered palindromes.
         *
         * @param x the integer to check
         * @return {@code true} if {@code x} is a palindrome, {@code false} otherwise
         */
        public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int reversed = 0, remainder, original = x;
        while (x != 0) {
            remainder = x % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            x /= 10; //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    }
}
