package com.leetcode169.week19;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for LeetCode 239: Sliding Window Maximum
 * 
 * Given an array of integers and a sliding window size k, find the maximum value
 * in each window as it slides from left to right through the array.
 * 
 * Time Complexity: O(n) - each element is added and removed from deque at most once
 * Space Complexity: O(k) - deque stores at most k elements
 */
public class SlidingWindowMaximum {
    
    /**
     * Finds the maximum value in each sliding window of size k.
     * 
     * Uses a monotonic decreasing deque to maintain potential maximum values.
     * The deque stores indices of array elements in decreasing order of their values.
     * 
     * Algorithm:
     * 1. Remove indices outside the current window from the front
     * 2. Remove indices with smaller values than current element from the back
     * 3. Add current index to the back
     * 4. The front of deque contains the index of maximum element in current window
     * 
     * @param nums the input array of integers
     * @param k the size of the sliding window
     * @return an array containing the maximum value for each window position
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove indices whose values are smaller than current element
            // (they will never be the maximum)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index
            deque.offerLast(i);
            
            // Add to result once we have a complete window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }

    /**
     * Main method to test the sliding window maximum solution.
     * Tests with example: nums = [4, 3, 11], k = 3
     * Expected output: [11]
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        
        int[] nums = {4, 3, 11};
        int k = 3;
        
        int[] result = solution.maxSlidingWindow(nums, k);
        
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("], k = " + k);
        
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
