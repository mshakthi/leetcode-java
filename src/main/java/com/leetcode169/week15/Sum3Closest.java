package com.leetcode169.week15;

import java.util.Arrays;

public class Sum3Closest {
    /**
     * Finds the sum of three integers in the array that is closest to the target value.
     * Uses a two-pointer approach with sorted array to efficiently find the closest sum.
     * 
     * @param nums the input array of integers
     * @param target the target value to find the closest sum to
     * @return the sum of three integers that is closest to the target
     * 
     * @throws ArrayIndexOutOfBoundsException if nums has fewer than 3 elements
     * 
     * Time Complexity: O(n^2) where n is the length of the array
     * Space Complexity: O(1) excluding the space used for sorting
     * 
     * Algorithm:
     * 1. Sort the input array
     * 2. For each element, use two pointers (left and right) to find the other two elements
     * 3. Calculate current sum and compare with closest sum found so far
     * 4. Move pointers based on whether current sum is less than or greater than target
     * 5. Return early if exact match is found
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;

        for(int i =0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1;

            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - currentSum) < Math.abs(target - closestSum)){
                    closestSum = currentSum;
                }

                if(currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
        
    }
}
