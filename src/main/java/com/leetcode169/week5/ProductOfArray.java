package com.leetcode169.week5;

public class ProductOfArray {

    /**
     * Calculates the product of all elements in the array except the element at each index.
     * 
     * <p>This method uses a two-pass approach without division:
     * <ul>
     *   <li>First pass: calculates prefix products (product of all elements before current index)</li>
     *   <li>Second pass: multiplies by suffix products (product of all elements after current index)</li>
     * </ul>
     * 
     * <p>Time Complexity: O(n) where n is the length of the input array
     * <p>Space Complexity: O(1) excluding the output array (no extra space used)
     * 
     * @param nums the input array of integers
     * @return an array where each element at index i is the product of all elements 
     *         in nums except nums[i]
     * 
     * @example
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * Explanation: 
     * - result[0] = 2*3*4 = 24
     * - result[1] = 1*3*4 = 12
     * - result[2] = 1*2*4 = 8
     * - result[3] = 1*2*3 = 6
     */
    public int[] productExceptSelf(int[] nums) {
        int preixProduct = 1;
        int SuffixProduct = 1;
        int n = nums.length;

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = preixProduct;
            preixProduct *= nums[i];
        }

        for(int i =n-1;i>=0;i--){
            result[i] *= SuffixProduct;
            SuffixProduct *= nums[i];
        }
        
        return result;
    }
    
}
