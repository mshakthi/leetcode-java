package com.leetcode169.week15;

public class MinInRotatedSortedArray {
    /**
     * Finds the minimum element in a rotated sorted array.
     * 
     * The array was originally sorted in ascending order and then rotated at some pivot.
     * This method uses binary search to find the minimum element in O(log n) time.
     * 
     * Algorithm:
     * - Uses two pointers (left and right) to perform binary search
     * - Compares the middle element with the rightmost element
     * - If mid element is greater than right element, the minimum is in the right half
     * - Otherwise, the minimum is in the left half (including mid)
     * - Continues until left and right pointers converge at the minimum element
     * 
     * @param nums the rotated sorted array with no duplicates
     * @return the minimum element in the array
     * 
     * @throws ArrayIndexOutOfBoundsException if the array is empty
     * 
     * Time Complexity: O(log n) where n is the length of the array
     * Space Complexity: O(1) as only constant extra space is used
     * 
     * Example:
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     */
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
