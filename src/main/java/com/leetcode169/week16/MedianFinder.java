package com.leetcode169.week16;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    /**
     * Adds a number to the data structure while maintaining the median property.
     * 
     * <p>This method uses two heaps to efficiently maintain elements such that the median
     * can be retrieved in constant time:
     * <ul>
     *   <li>maxHeap stores the smaller half of numbers (max heap)</li>
     *   <li>minHeap stores the larger half of numbers (min heap)</li>
     * </ul>
     * 
     * <p>The algorithm works as follows:
     * <ol>
     *   <li>If maxHeap is empty or the number is less than or equal to maxHeap's top,
     *       add it to maxHeap; otherwise add it to minHeap</li>
     *   <li>Balance the heaps to ensure maxHeap has at most one more element than minHeap</li>
     * </ol>
     * 
     * <p>Time Complexity: O(log n) where n is the number of elements
     * <p>Space Complexity: O(1) for this operation
     * 
     * @param num the integer number to be added to the data structure
     */
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <=maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
