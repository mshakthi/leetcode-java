package com.leetcode169.week10;

public class MaximumProductSubArray {
    /**
     * Finds the contiguous subarray within an array which has the largest product.
     * 
     * This method uses a two-pointer approach (prefix and suffix) to traverse the array
     * from both directions simultaneously. By maintaining running products from both ends,
     * it handles negative numbers effectively, as a negative number might become positive
     * when multiplied by another negative number from the opposite direction.
     * 
     * Algorithm:
     * - Traverse the array from left to right (prefix) and right to left (suffix)
     * - Maintain cumulative products in both directions
     * - Reset product to 1 when encountering 0 (as 0 breaks the product chain)
     * - Track the maximum product seen across both traversals
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) as only constant extra space is used
     * 
     * @param nums the input array of integers (can contain positive, negative, and zero values)
     * @return the maximum product of any contiguous subarray
     * 
     * @example
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: The subarray [2,3] has the largest product 6
     * 
     * @example
     * Input: nums = [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        for(int i = 0;i< n;i++){
            if(prefix ==0) prefix =1;
            if(suffix ==0) suffix =1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));

        }

        return max;
        
    }
}
