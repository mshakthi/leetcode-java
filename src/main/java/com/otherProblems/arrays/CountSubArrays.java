package com.otherProblems.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for counting subarrays with cost less than or equal to k.
 * 
 * <p>Given an integer array nums and an integer k, counts the number of subarrays
 * whose cost is defined as: cost = (max(nums[l..r]) - min(nums[l..r])) * (r - l + 1).
 * </p>
 * 
 * <p>Approach: Uses a sliding window technique with two deques to maintain
 * the maximum and minimum elements in the current window efficiently.
 * Time Complexity: O(n) where n is the length of nums.
 * Space Complexity: O(n) for the deques.
 * </p>
 */
public class CountSubArrays {
    /**
     * Counts the number of subarrays whose cost is less than or equal to k.
     * 
     * <p>The cost of a subarray is calculated as:
     * cost = (max_element - min_element) * subarray_length
     * </p>
     * 
     * @param nums the input integer array
     * @param k the maximum allowed cost threshold
     * @return the number of subarrays with cost <= k
     */
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long count = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();


        for(int right = 0; right < nums.length; right++){
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]){
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while(!maxDeque.isEmpty() && !minDeque.isEmpty() && (long)(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]) * (right - left + 1) > k){
                if(maxDeque.peekFirst() == left){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst() == left){
                    minDeque.pollFirst();
                }
                left++;
            }

            count += right - left + 1;
        }
        
        return count;
    }
}
