package com.leetcode169.week7;

/**
 * Sorts an array containing only 0s, 1s, and 2s in-place using the Dutch National Flag algorithm.
 * This class provides an efficient O(n) time and O(1) space solution for the sorting problem.
 * 
 * <p>The algorithm uses three pointers (left, mid, right) to partition the array into three sections:
 * <ul>
 *   <li>Elements from index 0 to left-1 are all 0s</li>
 *   <li>Elements from index left to mid-1 are all 1s</li>
 *   <li>Elements from index right+1 to end are all 2s</li>
 *   <li>Elements from index mid to right are yet to be examined</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the length of the array
 * <br>Space Complexity: O(1) as sorting is done in-place
 * 
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;

        while(mid<=right){
            if(nums[mid]==0){
                swap(nums, mid, left);
                left++;
                mid++;
            } else if(nums[mid]==2) {
                swap(nums, mid, right);
                right--;
            } else {
                mid++;
            }
        }
        
    } 


    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
