package com.leetcode169.week15;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}
