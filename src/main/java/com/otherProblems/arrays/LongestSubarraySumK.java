package com.otherProblems.arrays;

/**
 * Solution for finding the longest subarray with sum equal to k.
 * 
 * This class uses a sliding window (two-pointer) approach to efficiently find
 * the longest contiguous subarray whose sum equals the target value k.
 * 
 * Time Complexity: O(n) - each element is visited at most twice
 * Space Complexity: O(1) - only using constant extra space
 */
public class LongestSubarraySumK {
    /**
     * Finds the length of the longest subarray with sum equal to k.
     * 
     * Uses a sliding window approach where the left pointer expands the window
     * when sum is less than or equal to k, and contracts when sum exceeds k.
     * 
     * @param nums the input array of integers (can contain positive and negative numbers)
     * @param k the target sum
     * @return the length of the longest subarray with sum equal to k,
     *         or 0 if no such subarray exists
     * 
     * @example
     * Input: nums = [1, 2, 3, 1, 1, 1], k = 3
     * Output: 3 (subarray [3] or [1, 1, 1])
     */
    public int longestSubarraySum(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for(int right =0 ;right < nums.length; right++){
            sum+= nums[right];

            while(sum > k && left <= right){
                sum-= nums[left];
                left++;
            }

            if(sum == k){
                maxLength = Math.max(maxLength, right-left+1);
            }
        }

        return maxLength;
    }
}
