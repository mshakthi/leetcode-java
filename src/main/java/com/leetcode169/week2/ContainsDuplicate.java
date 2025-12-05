/**
 * Solution class for the "Contains Duplicate" problem.
 * This class provides a method to determine if an array contains any duplicate elements.
 */

/**
 * Checks if the given array contains any duplicate elements.
 * Uses a HashSet to track previously seen elements for efficient lookup.
 * 
 * @param nums the array of integers to check for duplicates
 * @return true if any value appears at least twice in the array, false otherwise
 * 
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(n) in the worst case when all elements are unique
 * 
 * @throws NullPointerException if nums is null
 */
package com.leetcode169.week2;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            } else {
                seen.add(num);
            }

        }

        return false;
    }
}
