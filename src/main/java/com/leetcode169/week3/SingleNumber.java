package com.leetcode169.week3;

public class SingleNumber {
    /**
     * Finds the single number in an array where every other element appears twice.
     * <p>
     * This method uses the XOR operation to identify the unique element in the array.
     * All elements except one appear exactly twice. The XOR of a number with itself is 0,
     * and the XOR of a number with 0 is the number itself. Thus, XOR-ing all elements
     * results in the unique element.
     *
     * @param nums the input array of integers where every element appears twice except for one
     * @return the single number that appears only once
     */
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int num: nums){
            xor = xor ^ num;
        }

        return xor;
        
    }
}
