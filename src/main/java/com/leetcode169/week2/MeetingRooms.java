package com.leetcode169.week2;

import java.util.Arrays;

/**
 * Determines if a person can attend all meetings given their intervals.
 * 
 * This class checks if there are any overlapping meeting times in the given
 * array of meeting intervals. Each interval is represented as [start, end].
 * 
 * Algorithm:
 * 1. Sort the intervals by their start time
 * 2. Iterate through sorted intervals and check if any meeting starts before
 *    the previous meeting ends
 * 3. If an overlap is found, return false; otherwise return true
 * 
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(1) if sorting is done in-place, O(n) otherwise
 * 
 * @param intervals 2D array where each element [start, end] represents a meeting interval
 * @return true if the person can attend all meetings without conflicts, false otherwise
 * 
 * Example:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false (meetings overlap)
 * 
 * Input: [[7,10],[2,4]]
 * Output: true (no overlap after sorting)
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
        
    }
}
