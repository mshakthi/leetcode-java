package com.leetcode169.week17;

import java.util.Arrays;

/**
 * Solution for Maximum Profit in Job Scheduling problem.
 * 
 * Given a set of jobs with start times, end times, and profits,
 * find the maximum profit that can be achieved by scheduling non-overlapping jobs.
 * 
 * This implementation uses dynamic programming with memoization and binary search
 * to find the optimal job scheduling.
 * 
 * Time Complexity: O(n log n) where n is the number of jobs
 * Space Complexity: O(n) for the memoization array
 */
public class MaxProfitJobScheduling {
    /**
     * Finds the maximum profit from scheduling non-overlapping jobs.
     * 
     * @param startTime array of job start times
     * @param endTime array of job end times
     * @param profit array of profits for each job
     * @return the maximum profit that can be achieved
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] memo = new int[50001];
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.fill(memo, -1);

        return dfs(0, jobs, 0, memo);

    }

    /**
     * Performs depth-first search with memoization to find maximum profit.
     * 
     * For each job, we have two choices:
     * 1. Include the job: add its profit and move to the next compatible job
     * 2. Exclude the job: move to the next job without adding profit
     * 
     * @param index current job index being considered
     * @param jobs 2D array of jobs sorted by start time [startTime, endTime, profit]
     * @param currentTime the current time (end time of last scheduled job)
     * @param memo memoization array to store computed results
     * @return maximum profit from current index onwards
     */
    public int dfs(int index, int[][] jobs, int currentTime, int[] memo) {
        if (index >= jobs.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        // take the job
        int nextIndex = findNextJob(index + 1, jobs, jobs[index][1]);
        int includeProfit = jobs[index][2] + dfs(nextIndex, jobs, jobs[index][1], memo);

        int excludeProfit = dfs(index + 1, jobs, currentTime, memo);

        memo[index] = Math.max(includeProfit, excludeProfit);
        return memo[index];
    }

    /**
     * Uses binary search to find the next job that starts at or after the given time.
     * 
     * @param index starting index for the search
     * @param jobs 2D array of jobs sorted by start time
     * @param currentTime the end time of the current job
     * @return index of the first job that starts at or after currentTime
     */
    public int findNextJob(int index, int[][] jobs, int currentTime) {
        int left = index;
        int right = jobs.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] < currentTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
