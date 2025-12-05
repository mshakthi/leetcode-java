package com.leetcode169.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
    /**
     * Finds all unique triplets in the array that sum up to zero.
     * 
     * This method uses a two-pointer approach combined with sorting to efficiently
     * find all triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, j != k,
     * and nums[i] + nums[j] + nums[k] == 0.
     * 
     * Algorithm:
     * 1. Sorts the input array in ascending order
     * 2. Iterates through each element as a potential first element of the triplet
     * 3. Uses two pointers (left and right) to find pairs that sum with the first element to zero
     * 4. Skips duplicate values to ensure unique triplets
     * 5. Uses a HashSet to store results and prevent duplicate triplets
     * 
     * Time Complexity: O(n²) where n is the length of the input array
     * - Sorting takes O(n log n)
     * - The nested while loop results in O(n²)
     * 
     * Space Complexity: O(n) for storing the result set
     * 
     * @param nums an array of integers that may contain duplicates
     * @return a list of lists containing all unique triplets that sum to zero
     *         Returns an empty list if no such triplets exist
     * 
     * @example
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * 
     * @example
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for(int i =0;i<nums.length;i++){
            int first = nums[i];
            int left = i+1;
            int right = nums.length -1;

            while(left < right){
                int sum = first + nums[left] + nums [right];
                if(sum == 0){
                    result.add(Arrays.asList(first, nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left +1]) left++;
                    while(left < right && nums[right] == nums[right -1]) right--;
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }

        }

        return new ArrayList<>(result);
    }
}
