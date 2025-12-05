package com.leetcode169.week2;

public class MajorityElement {
    /**
     * Finds the majority element in an array using Boyer-Moore Voting Algorithm.
     * The majority element is the element that appears more than ⌊n/2⌋ times.
     * 
     * <p>Algorithm explanation:
     * - Maintains a candidate for majority element and a count
     * - When count reaches 0, selects current element as new candidate
     * - Increments count if current element matches candidate, decrements otherwise
     * - The algorithm guarantees finding the majority element if it exists
     * 
     * @param nums the input array of integers (assumes majority element always exists)
     * @return the majority element that appears more than n/2 times
     * 
     * @implNote Time Complexity: O(n) - single pass through the array
     * @implNote Space Complexity: O(1) - uses constant extra space
     */
    public int majorityElement(int[] nums) {
        Integer candidate = null;

        int count = 0;

        for(int num: nums){
            if(count == 0){
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate;
        
    }

}
