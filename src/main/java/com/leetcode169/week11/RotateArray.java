package com.leetcode169.week11;

public class RotateArray {
            public void rotate(int[] nums, int k) {
                int n = nums.length;
                k = k%n;

                reverse(nums, n-k, n-1);
                reverse(nums, 0, n-k-1);
                reverse(nums, 0, n-1);
            }


        /**
         * Reverses the elements of the array within the specified range.
         * 
         * @param nums the array to be reversed
         * @param left the starting index of the range (inclusive)
         * @param right the ending index of the range (inclusive)
         */
        public void reverse(int[] nums, int left, int right){
            while(left< right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
}
