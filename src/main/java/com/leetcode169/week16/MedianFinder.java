package com.leetcode169.week16;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap
            = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /**
     * Adds a number to the data structure while maintaining the heap invariants.
     * 
     * This method ensures that the maxHeap contains the smaller half of the numbers
     * and the minHeap contains the larger half. The maxHeap may have one more element
     * than the minHeap if the total number of elements is odd.
     * 
     * Algorithm:
     * 1. Add the number to maxHeap
     * 2. Move the largest element from maxHeap to minHeap
     * 3. If minHeap becomes larger than maxHeap, balance by moving the smallest
     *    element from minHeap back to maxHeap
     * 
     * Time Complexity: O(log n) where n is the total number of elements
     * Space Complexity: O(1)
     * 
     * @param num the integer number to be added to the data structure
     */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
