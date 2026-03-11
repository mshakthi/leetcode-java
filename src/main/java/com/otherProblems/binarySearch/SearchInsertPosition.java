package com.otherProblems.binarySearch;

public class SearchInsertPosition {
    /**
     * Searches for the target value in a sorted array and returns its index.
     * If the target is not found, returns the index where it would be inserted to maintain sorted order.
     *
     * @param nums a sorted array of integers in non-decreasing order
     * @param target the value to search for or insert
     * @return the index of the target if found, otherwise the index where target should be inserted
     *
     * @example
     * searchInsert([1,3,5,6], 5) returns 2
     * searchInsert([1,3,5,6], 2) returns 1
     * searchInsert([1,3,5,6], 7) returns 4
     *
     * @complexity
     * Time Complexity: O(log n) - binary search
     * Space Complexity: O(1) - constant extra space
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1 , ans = n;

        while(low<=high){
            int mid = (high + low) /2;

            if(nums[mid] >= target){
                 ans = mid;
                 high = mid -1;
            } else {
                low = mid +1 ;
            }
        }
        
        return ans;
    }
}
