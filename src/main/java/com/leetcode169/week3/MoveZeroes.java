package com.leetcode169.week3;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * *Note that you must do this in-place without making a copy of the array.
 *
 *
 **Example 1:
 *  *Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;

        while(right < nums.length){
            if(nums[right] != 0){
                /**
                 * Stores the value at the left index position in a temporary variable.
                 * This is typically the first step in a swap operation to prevent data loss
                 * when exchanging values between two array positions.
                 */
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        
    }
}
