package com.leetcode169.week20;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeFromKLists {
    /**
     * Finds the smallest range that includes at least one number from each of the k lists.
     * 
     * This method uses a min-heap based approach to maintain a sliding window across all k lists.
     * It tracks the minimum and maximum values in the current window and updates the result whenever
     * a smaller range is found.
     * 
     * Algorithm:
     * 1. Initialize a min-heap with the first element from each list
     * 2. Track the maximum value among all elements in the heap
     * 3. While the heap contains exactly k elements (one from each list):
     *    - Pop the minimum element from the heap
     *    - If current range is smaller, update the result range
     *    - Add the next element from the same list to the heap
     *    - Update maximum if the new element is larger
     * 4. Return the range with the smallest difference
     * 
     * @param nums a list of k sorted lists of integers
     * @return an array containing two elements: [rangeStart, rangeEnd] representing 
     *         the smallest range that includes at least one number from each list
     * 
     * Time Complexity: O(n * k * log k) where n is the total number of elements and k is the number of lists
     * Space Complexity: O(k) for the min-heap
     */
      public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int max = Integer.MIN_VALUE;
        int min = 0;

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;


        for(int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }

        while(minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            min = curr[0];
            int listIndex = curr[1];
            int elementIndex = curr[2];
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                if (nextVal > max) {
                    max = nextVal;
                }
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }  
}
