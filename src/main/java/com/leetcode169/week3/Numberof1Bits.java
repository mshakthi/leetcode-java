package com.leetcode169.week3;

public class Numberof1Bits {
    /**
     * Calculates the Hamming weight (number of 1-bits) of an integer.
     * 
     * Uses Brian Kernighan's algorithm to efficiently count the set bits by
     * repeatedly removing the lowest set bit until the number becomes zero.
     * Time complexity: O(k) where k is the number of set bits.
     * Space complexity: O(1)
     *
     * @param n the input integer whose Hamming weight is to be calculated
     * @return the number of 1-bits (set bits) in the binary representation of n
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1); // removes the lowest set bit
            count++;
        }

        return count;
    }
}
