package com.leetcode169.week3;

/**
 * Solution for LeetCode problem: Backspace String Compare
 * 
 * This class provides functionality to compare two strings after processing backspace characters.
 * A backspace is represented by the '#' character, which removes the previous character.
 * 
 * <p>Example:
 * <ul>
 *   <li>Input: s = "ab#c", t = "ad#c" → Output: true (both become "ac")</li>
 *   <li>Input: s = "ab##", t = "c#d#" → Output: true (both become "")</li>
 *   <li>Input: s = "a#c", t = "b" → Output: false ("c" vs "b")</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n + m) where n and m are the lengths of strings s and t
 * <p>Space Complexity: O(n + m) for storing the processed strings
 */

/**
 * Compares two strings after processing backspace characters.
 * 
 * @param s the first string to compare
 * @param t the second string to compare
 * @return true if both strings are equal after processing backspaces, false otherwise
 */

/**
 * Builds the final string after processing all backspace characters.
 * Processes the string from right to left, keeping track of backspace count.
 * 
 * @param str the input string containing characters and backspaces ('#')
 * @return the processed string after applying all backspace operations
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    public String buildString(String str){
        StringBuilder result = new StringBuilder();

        int backSpace = 0;

        for(int i = str.length() -1; i >=0; i--){
            char ch = str.charAt(i);

            if(ch == '#'){
                backSpace++;
            } else {
                if(backSpace > 0){
                    backSpace--;
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
