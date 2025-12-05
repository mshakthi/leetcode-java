/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *  *You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *  *You can return the answer in any order.
 *
 *
 * <p>
 * Algorithm: Uses a HashMap to store the complement (target - nums[i]) as key
 * and the index i as value. While iterating the array, if the current number
 * exists as a key in the map, a previous index whose value complements the
 * current number has been found and the pair of indices is returned
 * immediately.</p>
 *
 * <p>
 * Behavior notes: - Indices returned are zero-based. - If multiple valid pairs
 * exist, the method returns the first pair discovered by the single-pass
 * left-to-right scan. - If no valid pair exists, an empty int[] is returned. -
 * The method accepts negative numbers and duplicate values. - Passing a null
 * reference for nums will result in a NullPointerException.</p>
 *
 * <p>
 * Complexity: - Time: O(n), where n is nums.length (single pass). - Space: O(n)
 * additional space for the HashMap in the worst case.</p>
 *
 * Example: Given nums = [2, 7, 11, 15], target = 9 -> returns [0, 1].
 */
/**
 * Finds two indices such that the values at those indices add up to the specified target.
 *
 * @param nums   the input array of integers to search (must not be null)
 * @param target the target sum to find
 * @return an int array of length 2 containing the indices of the two numbers
 * that add up to target (indices are zero-based). If no such pair exists,
 * returns an empty int[].
 * @throws NullPointerException if nums is null
 */
package com.leetcode169.week1;

import java.util.HashMap;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> diff = new HashMap<>();

            for(int i =0;i< nums.length;i++){
                if(diff.containsKey(nums[i])){
                    return new int[]{diff.get(nums[i]), i};
                } else {
                    diff.put(target - nums[i], i);
                }
            }

            return new int[]{};   
    }
    
}
