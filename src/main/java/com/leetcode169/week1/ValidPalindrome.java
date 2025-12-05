package com.leetcode169.week1;

/**
 * A class that provides functionality to validate whether a given string is a palindrome.
 * A palindrome is a string that reads the same forwards and backwards, ignoring non-alphanumeric
 * characters and case differences.
 */

/**
 * Determines whether the given string is a valid palindrome.
 * This method ignores non-alphanumeric characters and treats uppercase and lowercase
 * letters as equivalent.
 *
 * @param s the string to check for palindrome property
 * @return true if the string is a palindrome (considering only alphanumeric characters
 *         and ignoring case), false otherwise
 * 
 * @implNote Uses a two-pointer approach starting from both ends of the string,
 *           moving inward while skipping non-alphanumeric characters and comparing
 *           characters in a case-insensitive manner.
 * 
 * @example
 * isPalindrome("A man, a plan, a canal: Panama") returns true
 * isPalindrome("race a car") returns false
 * isPalindrome(" ") returns true
 */
public class ValidPalindrome {
       public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while(left <= right) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if(!Character.isLetterOrDigit(leftChar)) {
                    left++;
                    continue;
                }

                if(!Character.isLetterOrDigit(rightChar)) {
                    right--;
                    continue;
                }

                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }

                left++;
                right--;

            }
        

            return true;
    }
}
