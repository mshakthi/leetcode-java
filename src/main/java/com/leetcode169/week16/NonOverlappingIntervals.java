package com.leetcode169.week16;

import java.util.Arrays;

public class NonOverlappingIntervals {

    /**
     * Calculates the minimum number of intervals that need to be removed to make the rest non-overlapping.
     * 
     * The algorithm uses a greedy approach:
     * 1. Sorts intervals by their end time in ascending order
     * 2. Iterates through sorted intervals, keeping track of the end time of the last non-overlapping interval
     * 3. If the current interval's start time is less than the tracked end time, it overlaps and must be removed
     * 4. Otherwise, updates the end time to the current interval's end time
     * 
     * @param intervals a 2D array where each element is an interval [start, end]
     * @return the minimum number of intervals to remove to make all remaining intervals non-overlapping
     * 
     * @throws NullPointerException if intervals is null
     * 
     * Time Complexity: O(n log n) due to sorting, where n is the number of intervals
     * Space Complexity: O(1) excluding the space used by the sorting algorithm
     * 
     * Example:
     * Input: [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1 (remove [1,3] to make intervals non-overlapping)
     */
     public int eraseOverlapIntervals(int[][] intervals) {
        int count =0;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int end = Integer.MIN_VALUE;
        
        for(int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    } 
}
