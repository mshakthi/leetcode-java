package com.leetcode169.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /**
     * Merges overlapping intervals in a 2D array.
     * 
     * This method takes an array of intervals where each interval is represented as [start, end],
     * sorts them, and merges any overlapping intervals into single intervals.
     * 
     * @param intervals a 2D array where each element is an interval [start, end]
     * @return a 2D array containing the merged intervals with no overlaps
     * 
     * @throws ArrayIndexOutOfBoundsException if intervals array is empty
     * 
     * Example:
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Intervals [1,3] and [2,6] overlap, so they are merged into [1,6]
     */
    public int[][] merge(int[][] intervals) {
        sortIntervals(intervals);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int j =1;j<intervals.length;j++){
            int[] last = merged.get(merged.size() -1);

            if(intervals[j][0] > last[1]){
                merged.add(intervals[j]);
            } else {
                merged.remove(merged.size()-1);
                last[1] = Math.max(last[1], intervals[j][1]);
                merged.add(last);
            }

        }

        return merged.toArray(new int[merged.size()][]);

        
    }


    public void sortIntervals(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
    }
}
