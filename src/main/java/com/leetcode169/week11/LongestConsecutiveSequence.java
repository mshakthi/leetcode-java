package com.leetcode169.week11;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * Finds the length of the longest consecutive sequence in an unsorted array.
     * 
     * This method uses a HashSet to achieve O(n) time complexity by:
     * 1. First adding all numbers to a set for O(1) lookup
     * 2. For each number, checking if it's the start of a sequence (no num-1 exists)
     * 3. If it's a sequence start, counting consecutive numbers forward
     * 
     * @param nums the input array of integers (may contain duplicates)
     * @return the length of the longest consecutive sequence of integers
     * 
     * @example
     * Input: nums = [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive sequence is [1, 2, 3, 4]
     * 
     * @example
     * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
     * Output: 9
     * Explanation: The longest consecutive sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]
     * 
     * Time Complexity: O(n) - each number is visited at most twice
     * Space Complexity: O(n) - for the HashSet storage
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        int maxLength = 0;

        for(int num: nums){
            if(!numSet.contains(num-1)){
                int curr = num;
                int currLength = 1;

                while(numSet.contains(curr + 1)){
                    curr++;
                    currLength++;
                }
                maxLength = Math.max(maxLength, currLength);
            }

        }
        
        return maxLength;
    }
}
