package com.leetcode169.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that generates all possible permutations of an array of integers.
 * 
 * <p>This implementation uses backtracking to generate permutations by swapping elements
 * at different positions and recursively building all possible arrangements.
 * 
 * <p>Example:
 * <pre>
 * Permutations p = new Permutations();
 * int[] nums = {1, 2, 3};
 * List<List<Integer>> result = p.permute(nums);
 * // Returns: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 * </pre>
 * 
 * <p>Time Complexity: O(n! * n) where n is the length of the input array
 * <p>Space Complexity: O(n) for the recursion stack, not counting the output
 */
public class Permutations {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            buildPermutations(0, nums, result);
            return result;
        
    }

    public void buildPermutations(int index, int[] nums, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int num : nums){
                current.add(num);
            }
            result.add(current);
            return;
        }

        for(int i = index;i< nums.length;i++){
            swap(nums, index, i);
            buildPermutations(index +1, nums, result);
            swap(nums, index, i);
        }
        
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
