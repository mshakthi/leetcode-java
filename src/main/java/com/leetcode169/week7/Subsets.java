package com.leetcode169.week7;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        buildSubsets(0, nums, new ArrayList<>(), results);

        return results;
    }

    /**
     * Recursively builds all possible subsets of the given array using backtracking.
     * 
     * This method explores two choices at each index:
     * 1. Include the current element in the subset
     * 2. Exclude the current element from the subset
     * 
     * @param index the current index being processed in the nums array
     * @param nums the input array of integers
     * @param current the current subset being built
     * @param results the list that stores all generated subsets
     * 
     * Base case: When index reaches nums.length, a complete subset is formed
     * and added to results.
     * 
     * Time Complexity: O(2^n) where n is the length of nums
     * Space Complexity: O(n) for the recursion stack depth
     */
    public void buildSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> results){
        if(index == nums.length){
            results.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        buildSubsets(index +1, nums, current, results);
        current.remove(current.size() -1);
        buildSubsets(index +1, nums, current, results);
    }
    
    
}
