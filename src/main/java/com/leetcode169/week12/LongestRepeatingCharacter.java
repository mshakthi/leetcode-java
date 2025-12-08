package com.leetcode169.week12;

public class LongestRepeatingCharacter {

    /**
     * Finds the length of the longest substring that can be obtained by replacing at most k characters
     * with any other character to make all characters in the substring the same.
     * 
     * This method uses a sliding window approach with two pointers (left and right) to efficiently
     * find the maximum length. It maintains a count array to track the frequency of each character
     * in the current window and keeps track of the maximum frequency character.
     * 
     * Algorithm:
     * 1. Expand the window by moving the right pointer and update character frequency
     * 2. Track the maximum frequency of any character in the current window
     * 3. If the number of characters that need to be replaced (window size - max frequency) exceeds k,
     *    shrink the window from the left
     * 4. Update the maximum length found so far
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) as the count array is fixed size (26 for uppercase letters)
     * 
     * @param s the input string containing only uppercase English letters
     * @param k the maximum number of characters that can be replaced
     * @return the length of the longest substring with repeating characters after at most k replacements
     */
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int maxCount = 0;

        int left = 0;
        int maxLength =0;

        int right = 0;

        while(right < s.length()){
            count[s.charAt(right) - 'A']++;

            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while((right - left +1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    
}
