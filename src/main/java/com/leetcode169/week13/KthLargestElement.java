package com.leetcode169.week13;

import java.util.PriorityQueue;

public class KthLargestElement {
    /**
     * Finds the kth largest element in an unsorted array.
     * 
     * This method uses a min-heap (priority queue) of size k to efficiently find the kth largest element.
     * The heap maintains the k largest elements seen so far, with the smallest of these k elements at the root.
     * 
     * Time Complexity: O(n log k) where n is the length of the array
     * - Each insertion into the heap takes O(log k)
     * - We perform n insertions
     * 
     * Space Complexity: O(k) for storing k elements in the heap
     * 
     * @param nums the input array of integers (can be unsorted)
     * @param k the position of the largest element to find (1-indexed, where 1 is the largest)
     * @return the kth largest element in the array
     * @throws IllegalArgumentException if k is less than 1 or greater than nums.length (implicit)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}
