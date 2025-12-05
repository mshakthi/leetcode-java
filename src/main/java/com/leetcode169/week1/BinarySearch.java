package com.leetcode169.week1;

/**
 * Binary Search implementation to find the index of a target element in a sorted array.
 * 
 * This class provides a search method that implements the binary search algorithm,
 * which efficiently searches for a target value within a sorted array by repeatedly
 * dividing the search interval in half.
 * 
 * Time Complexity: O(log n) where n is the length of the array
 * Space Complexity: O(1) as it uses constant extra space
 * 
 */

/**
 * Searches for a target value in a sorted integer array using binary search algorithm.
 * 
 * The method assumes that the input array is sorted in ascending order.
 * It uses two pointers (low and high) to narrow down the search space by
 * comparing the middle element with the target value.
 * 
 * Example:
 * <pre>
 * BinarySearch bs = new BinarySearch();
 * int[] nums = {1, 3, 5, 7, 9};
 * int result = bs.search(nums, 5); // returns 2
 * int result2 = bs.search(nums, 6); // returns -1
 * </pre>
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = low +(high - low)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid -1; 
            }
        }

        return -1;
        
    }
}
