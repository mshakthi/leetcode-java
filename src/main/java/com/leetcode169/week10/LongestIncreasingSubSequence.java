package com.leetcode169.week10;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
    /**
     * Finds the length of the longest increasing subsequence in the given array.
     *
     * This method uses a dynamic programming approach with binary search to efficiently
     * determine the length of the longest strictly increasing subsequence in the input array.
     * It maintains a list that represents the smallest possible tail of all increasing subsequences
     * with different lengths found so far.
     *
     * @param nums the input array of integers
     * @return the length of the longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();

        for(int i =0;i<nums.length;i++){
            int last = seq.size() > 0 ? seq.get(seq.size()-1): Integer.MIN_VALUE; 

            if(last< nums[i]){
                seq.add(nums[i]);
            } else {
                int index = binarySearch(seq, nums[i]);
                seq.set(index, nums[i]);
            }
        }


        return seq.size();
        
    }


    public int binarySearch(List<Integer> seq, int target){
        int low = 0;
        int high = seq.size()-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(seq.get(mid) == target){
                return mid;
            } else if(seq.get(mid) < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low;
    }
}
