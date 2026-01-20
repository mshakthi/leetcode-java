package com.leetcode169.week18;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Represents a time interval with a start and end time.
 */
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

/**
 * Solution for finding common free time intervals across all employees.
 * <p>
 * Given a list of schedules for each employee, where each schedule is a list of non-overlapping intervals,
 * this class finds all the common free time intervals for all employees.
 * </p>
 */
public class EmployeeFreeTime {
    /**
     * Finds all common free time intervals for all employees.
     * <p>
     * Algorithm:
     * 1. Merge all intervals from all employees into a priority queue sorted by start time
     * 2. Iterate through sorted intervals and merge overlapping ones
     * 3. Gaps between merged intervals represent common free time
     * </p>
     * 
     * @param schedule A list where each element is a list of intervals representing one employee's busy time
     * @return A list of intervals representing common free time for all employees
     * 
     * Time Complexity: O(N log N) where N is the total number of intervals
     * Space Complexity: O(N) for the priority queue
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);  

        for(List<Interval> emp: schedule){
            for(Interval interval: emp){
                pq.offer(interval);
            }
        }
        
        Interval prev = pq.poll();

        while(!pq.isEmpty()){
            Interval curr = pq.poll();

            if(prev.end < curr.start) {
                res.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {
                prev.end = Math.max(prev.end, curr.end);
            }


        }

        return res;
        
    } 
}
