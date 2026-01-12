package com.leetcode169.week3;

import java.util.HashMap;

/**
 * Solution for converting Roman numerals to integers.
 * 
 * Roman numerals are represented by seven different symbols:
 * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 * 
 * Special cases (subtractive notation):
 * - IV = 4, IX = 9
 * - XL = 40, XC = 90
 * - CD = 400, CM = 900
 */
public class RomanToInteger {
    /**
     * Converts a Roman numeral string to its integer representation.
     * 
     * Algorithm:
     * - Iterate through the string from left to right
     * - If current value is less than next value, subtract current from next (subtractive case)
     * - Otherwise, add current value to result
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - fixed size HashMap
     * 
     * @param s the Roman numeral string (e.g., "III", "IV", "MCMXCIV")
     * @return the integer value of the Roman numeral
     */
    public int romanToInt(String s) {

        HashMap<Character, Integer> vals = new HashMap<>();
        vals.put('I', 1);
        vals.put('V', 5);
        vals.put('X', 10);
        vals.put('L', 50);
        vals.put('C', 100);
        vals.put('D', 500);
        vals.put('M', 1000);

        int ans=0;
        int i = 0;
        int n = s.length();
        while(i<n){
            char ch = s.charAt(i);
            int currVal = vals.get(ch);
            int nextVal =0;
            if(i+1<n){
                char nextCh = s.charAt(i+1);
                nextVal = vals.get(nextCh);
            }

            if(currVal< nextVal){
                ans += (nextVal - currVal);
                i+=2;

            } else {
                ans +=currVal;
                i+=1;
            }
        }


        return ans;
        
    }
}
