package com.leetcode169.week3;

import java.util.Arrays;

/**
 * Finds the longest common prefix string amongst an array of strings.
 * 
 * <p>This implementation first sorts the input array by string length in ascending order,
 * then uses the shortest string as the initial candidate for the longest common prefix.
 * It iteratively checks if each subsequent string starts with the current prefix candidate.
 * If a string doesn't start with the current prefix, the prefix is shortened by removing
 * the last character until a match is found or the prefix becomes empty.</p>
 * 
 * <p>Time Complexity: O(n * log n * m + n * m) where n is the number of strings and m is 
 * the length of the shortest string. The sorting takes O(n * log n * m) and the prefix 
 * matching takes O(n * m) in the worst case.</p>
 * 
 * <p>Space Complexity: O(1) excluding the space used for sorting, as only a constant 
 * amount of extra space is used.</p>
 * 
 * @param strs an array of strings to find the common prefix from
 * @return the longest common prefix string, or an empty string if there is no common prefix
 * @throws NullPointerException if the input array is null or contains null elements
 * 
 * @example
 * <pre>
 * longestCommonPrefix(new String[]{"flower", "flow", "flight"}) returns "fl"
 * longestCommonPrefix(new String[]{"dog", "racecar", "car"}) returns ""
 * longestCommonPrefix(new String[]{"interview", "internet", "internal"}) returns "inte"
 * </pre>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> Integer.compare(a.length(), b.length()));

        String longest = strs[0];

        int i = 1;
        while(i< strs.length && longest.length() >0){
            String current = strs[i];

            if(current.startsWith(longest)){
                i++;
            } else {
                longest = longest.substring(0, longest.length() -1);
            }
        }

        return longest;
        
    }
    
}
