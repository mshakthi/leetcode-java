/**
 * Decodes a string of digits into the number of possible ways it can be decoded.
 * 
 * The decoding follows the pattern where 'A' -> "1", 'B' -> "2", ..., 'Z' -> "26".
 * For example, "12" can be decoded as "AB" (1 2) or "L" (12), giving 2 ways.
 * 
 * This solution uses dynamic programming where:
 * - dp[i] represents the number of ways to decode the substring s[0...i-1]
 * - dp[0] = 1 (empty string has one way to decode)
 * - dp[1] = 1 (single non-zero digit has one way to decode)
 * 
 * For each position i, we consider:
 * 1. Single digit decode: If current character is not '0', add dp[i]
 * 2. Two digit decode: If the two-digit number formed by previous and current 
 *    characters is between 10 and 26 (inclusive), add dp[i-1]
 * 
 * @param s the input string containing only digits
 * @return the total number of ways to decode the string, or 0 if the string 
 *         is empty or starts with '0'
 * 
 * @example
 * numDecodings("12") returns 2 (can be decoded as "AB" or "L")
 * numDecodings("226") returns 3 (can be decoded as "BZ", "VF", or "BBF")
 * numDecodings("06") returns 0 (invalid as it starts with '0')
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the dp array
 */
package com.leetcode169.week14;

public class DecodeWays {

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1; // An empty string has one way to decode
        dp[1] = 1; // A single non-zero digit has one way to decode

        for(int i =1;i<n;i++){
            char currentChar = s.charAt(i);
            char previousChar = s.charAt(i-1);

            // Check for single digit decode
            if(currentChar != '0'){
                dp[i+1] += dp[i];
            }

            // Check for two digit decode
            int twoDigit = (previousChar - '0') * 10 + (currentChar - '0');
            if(twoDigit >=10 && twoDigit <=26){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[n];

        
    } 
}
