package com.leetcode169.week12;

import java.util.HashMap;

public class ContiguousArray {
    /**
     * Finds the maximum length of a contiguous subarray with an equal number of 0s and 1s.
     * 
     * This method uses a HashMap to track the cumulative count difference between 1s and 0s.
     * When the same count is encountered again, it means the subarray between these two indices
     * has an equal number of 0s and 1s (since the count difference is the same).
     * 
     * Algorithm:
     * - Treat 0s as -1 and 1s as +1
     * - Maintain a running count (cumulative sum)
     * - Store each unique count with its first occurrence index in a HashMap
     * - When a count repeats, calculate the subarray length and update maxLength
     * - Initialize map with (0, -1) to handle subarrays starting from index 0
     * 
     * @param nums the input binary array containing only 0s and 1s
     * @return the length of the maximum contiguous subarray with equal number of 0s and 1s,
     *         or 0 if no such subarray exists
     * 
     * @throws NullPointerException if nums is null
     * 
     * Time Complexity: O(n) where n is the length of the input array
     * Space Complexity: O(n) for the HashMap storage
     * 
     * Example:
     * Input: nums = [0,1,0]
     * Output: 2 (subarray [0,1] or [1,0])
     * 
     * Input: nums = [0,1,1,0,1,1,1,0]
     * Output: 4 (subarray [0,1,1,0] or [1,0,1,1] at different positions)
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with sum 0 at index -1
        int maxLength = 0;
        int count = 0;
        
        for(int i =0;i<nums.length;i++){
            count+=nums[i] == 1 ? 1 : -1;

            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
