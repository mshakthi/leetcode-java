package com.leetcode169.week9;

public class GasStation {
    /**
     * Determines the starting gas station index from which a complete circuit can be made.
     * 
     * This method uses a greedy approach to find if there exists a starting gas station
     * from which you can travel around the circuit once in the clockwise direction.
     * 
     * Algorithm:
     * - Maintains a running total of net gas (gas[i] - cost[i]) to check feasibility
     * - Tracks current tank level to identify potential starting points
     * - If current tank becomes negative at any point, the next station becomes the new candidate
     * - If total net gas is non-negative, a solution exists at the identified start position
     * 
     * @param gas  an array where gas[i] represents the amount of gas at station i
     * @param cost an array where cost[i] represents the cost of traveling from station i to i+1
     * @return the starting gas station index if a complete circuit is possible, otherwise -1
     * 
     * Time Complexity: O(n) where n is the number of gas stations
     * Space Complexity: O(1) as only constant extra space is used
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total =0;
        int curr = 0;
        int start = 0;
        
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if(curr < 0){
                curr =0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }
}
