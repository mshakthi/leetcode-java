package com.leetcode169.week4;

public class MaximumSubArray {
    /**
     * Finds the contiguous subarray within a one-dimensional array of numbers which has the largest sum.
     * This implementation uses Kadane's algorithm to solve the maximum subarray problem in O(n) time complexity.
     * 
     * The algorithm maintains a running sum of the current subarray. If the running sum becomes negative,
     * it resets to 0, as any negative sum would only decrease the value of subsequent subarrays.
     * The maximum sum encountered during the iteration is tracked and returned.
     * 
     * @param nums an array of integers (can contain positive, negative, or zero values)
     * @return the sum of the contiguous subarray with the largest sum
     * 
     * @throws NullPointerException if nums is null
     * 
     * Example:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum of 6.
     */
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int num: nums){
            curr += num;

            if(curr < 0){
                curr = 0;
            }
            
            max = Math.max(max, curr);
        }

        return max;
        
    }
}
