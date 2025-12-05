package com.leetcode169.week6;

/**
 * Solution for searching a target value in a rotated sorted array.
 * 
 * <p>This class implements a search algorithm that finds a target value in an array
 * that was originally sorted in ascending order but has been rotated at some pivot point.
 * For example, [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2] after rotation.</p>
 * 
 * <p>The algorithm works in two phases:
 * <ol>
 *   <li>Find the pivot point (the index of the minimum element) where the rotation occurred</li>
 *   <li>Perform binary search on the appropriate sorted subarray (before or after pivot)</li>
 * </ol>
 * </p>
 * 
 * <p>Time Complexity: O(log n) where n is the length of the array</p>
 * <p>Space Complexity: O(1) as only constant extra space is used</p>
 * 
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        int pivot = left;

        int leftSearch = binarySearch(nums, 0, pivot -1, target);
        if(leftSearch != -1){
            return leftSearch;
        }

        return binarySearch(nums, pivot, nums.length -1, target);
        
    }
    
    
    public int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}
