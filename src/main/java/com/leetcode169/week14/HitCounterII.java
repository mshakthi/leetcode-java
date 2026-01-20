package com.leetcode169.week14;

/**
 * A hit counter that tracks the number of hits received in the past 5 minutes (300 seconds).
 * Uses a bucketing approach with 300 buckets to efficiently track hits within the time window.
 * Space complexity: O(1) - fixed size arrays of 300 elements
 * Time complexity: O(1) for hit(), O(300) = O(1) for getHits()
 */
public class HitCounterII {
    /** Array to store the most recent timestamp for each bucket */
    private int[] times;
    /** Array to store the hit count for each bucket */
    private int[] hits;

    public HitCounterII() {
        times = new int[300];
        hits = new int[300];
    }

    /**
     * Records a hit at the given timestamp.
     * Uses modulo to map the timestamp to a bucket. If the bucket contains a stale timestamp,
     * it resets the bucket with the new timestamp and count of 1. Otherwise, increments the count.
     * 
     * @param timestamp the timestamp at which the hit occurred (in seconds)
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;

        if (times[index] != timestamp) {
            // bucket is stale → reset
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /**
     * Returns the number of hits in the past 5 minutes (300 seconds) from the given timestamp.
     * Iterates through all buckets and sums up hits for buckets within the 300-second window.
     * 
     * @param timestamp the current timestamp (in seconds)
     * @return the total number of hits in the past 300 seconds
     */
    public int getHits(int timestamp) {
        int totalHits = 0;

        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                totalHits += hits[i];
            }
        }
        return totalHits;
    }
}
