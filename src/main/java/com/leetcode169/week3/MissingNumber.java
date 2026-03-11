package com.leetcode169.week3;

public class MissingNumber {
        /**
         * Finds the missing number in an array containing n distinct numbers from the range [0, n].
         * 
         * Uses the mathematical approach of comparing the expected sum of numbers from 0 to n
         * with the actual sum of the array elements. The difference gives the missing number.
         * 
         * Time Complexity: O(n) - where n is the length of the array
         * Space Complexity: O(1) - only uses constant extra space
         * 
         * @param nums an array of n distinct integers in the range [0, n]
         * @return the missing number from the range [0, n]
         * 
         * Example:
         *   Input: nums = [3, 0, 1]
         *   Output: 2
         *   Explanation: The array contains numbers 0, 1, 3 and is missing 2
         */
        public int missingNumber(int[] nums) {
        int length = nums.length;
        int expectedSum = ((length) * (length+1))/2;

        int sum  = 0;
        for(int num: nums){
            sum+=num;
        }

        return expectedSum-sum; 
    }
}
