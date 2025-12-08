package com.leetcode169.week13;

import java.util.HashMap;

public class SubArraySum {

    /**
     * Finds the total number of continuous subarrays whose sum equals to k.
     * 
     * This method uses a HashMap to store the frequency of prefix sums encountered
     * while iterating through the array. For each element, it calculates the current
     * prefix sum and checks if removing a previous prefix sum (complement) would
     * result in a subarray sum equal to k.
     * 
     * Algorithm:
     * 1. Maintain a running sum (currSum) of elements
     * 2. For each prefix sum, check if (currSum - k) exists in the map
     * 3. If it exists, add its frequency to the count (these are valid subarrays)
     * 4. Store the current prefix sum frequency in the map
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the HashMap storing prefix sums
     * 
     * @param nums the input array of integers
     * @param k the target sum to find in subarrays
     * @return the total count of continuous subarrays with sum equal to k
     * 
     * @example
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Explanation: There are 2 subarrays with sum 2: [1,1] at indices (0,1) and (1,2)
     */
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: one way to have sum 0

        int currSum = 0;
        int count = 0;

        for(int num: nums){
            currSum+= num;

            if(currSum == k){
                count++;
            }
            int complement = currSum - k;

            if(prefixSumCount.containsKey(complement)){
                count += prefixSumCount.get(complement);
            }

            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            
        }

        return count;   
    }
    
}
