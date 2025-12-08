package com.leetcode169.week14;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {
    int total;
    Deque<int[]> deque;
   
    public HitCounter() {
        deque = new LinkedList<>();
        total = 0;
    }
    
    public void hit(int timestamp) {
        if(deque.isEmpty() || deque.getLast()[0] != timestamp) {
            deque.offerLast(new int[]{timestamp, 1});
        } else {
            deque.getLast()[1]++;
        }
        total++;
    }
    
    /**
     * Returns the number of hits in the past 5 minutes (300 seconds) from the given timestamp.
     * 
     * This method removes all hits that occurred more than 300 seconds before the given timestamp
     * from the deque and updates the total count accordingly. It then returns the updated total
     * representing the number of hits within the valid time window.
     *
     * @param timestamp the current timestamp in seconds
     * @return the total number of hits in the past 300 seconds from the given timestamp
     */
    public int getHits(int timestamp) {
        while(!deque.isEmpty() && deque.getFirst()[0] <=timestamp-300) {
            total -= deque.getFirst()[1];
            deque.pollFirst();
        }
        
        return total;
    } 
}
