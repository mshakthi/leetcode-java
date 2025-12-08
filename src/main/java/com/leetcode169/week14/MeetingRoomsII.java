package com.leetcode169.week14;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    /**
     * Calculates the minimum number of meeting rooms required to accommodate all meetings.
     * 
     * This method uses a greedy approach with a priority queue to efficiently determine
     * the minimum number of conference rooms needed. It sorts meetings by start time and
     * tracks the earliest ending meeting to determine if a room can be reused.
     * 
     * Algorithm:
     * 1. Sort all intervals by their start times
     * 2. Use a min-heap (priority queue) to track end times of ongoing meetings
     * 3. For each meeting, check if it can reuse a room (starts after earliest ending meeting)
     * 4. If reusable, remove that meeting from the heap; otherwise, a new room is needed
     * 5. Add the current meeting's end time to the heap
     * 
     * @param intervals A 2D array where each element is [start_time, end_time] representing
     *                  a meeting's time interval. Assumes non-null input with at least one interval.
     * @return The minimum number of meeting rooms required to schedule all meetings without conflicts
     * 
     * @throws NullPointerException if intervals is null or contains null elements
     * 
     * Time Complexity: O(n log n) where n is the number of meetings
     *                  - O(n log n) for sorting
     *                  - O(n log n) for heap operations (n insertions/deletions)
     * Space Complexity: O(n) for the priority queue in worst case when all meetings overlap
     * 
     * Example:
     * Input: [[0,30],[5,10],[15,20]]
     * Output: 2
     * Explanation: One room for [0,30] and another for meetings [5,10] and [15,20]
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals[0][1]);

        for(int i =1;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if( start >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.offer(end);
        }

        return endTimes.size();
    }
}
