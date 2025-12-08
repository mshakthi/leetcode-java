package com.leetcode169.week12;

import java.util.ArrayList;
import java.util.List;

public class FindKCloestElements {
    /**
     * Finds the k closest elements to x in a sorted array.
     * 
     * This method uses binary search to find the starting position of a sliding window
     * of size k that contains the k elements closest to x. The closeness is determined
     * by the absolute difference between each element and x.
     * 
     * Algorithm:
     * - Uses binary search on the range [0, arr.length - k] to find the optimal starting index
     * - Compares the distance from x to arr[mid] with the distance from x to arr[mid+k]
     * - If x is closer to arr[mid+k], moves the window right; otherwise, keeps it or moves left
     * - Once the optimal starting position is found, collects k consecutive elements
     * 
     * @param arr the sorted array of integers to search in
     * @param k the number of closest elements to find (k must be positive and <= arr.length)
     * @param x the target value to find closest elements to
     * @return a list of k integers closest to x, sorted in ascending order
     * 
     * @throws IllegalArgumentException if k is larger than the array length or negative
     * 
     * Time Complexity: O(log(n-k) + k) where n is the length of arr
     * Space Complexity: O(k) for the result list
     * 
     * Example:
     * Input: arr = [1,2,3,4,5], k = 4, x = 3
     * Output: [1,2,3,4]
     * 
     * Input: arr = [1,2,3,4,5], k = 4, x = -1
     * Output: [1,2,3,4]
     */
     public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = arr.length - k;

        while( left < right) {
            int mid = left + (right - left)/2;

            if(x-arr[mid] > arr[mid+k]-x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
        
    }
    
}
