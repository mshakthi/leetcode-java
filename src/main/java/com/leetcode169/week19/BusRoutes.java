package com.leetcode169.week19;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Solution for LeetCode 815 - Bus Routes problem.
 * 
 * This class solves the problem of finding the minimum number of buses needed
 * to travel from a source bus stop to a target bus stop, given a set of bus routes.
 * Each bus route is circular, and you can board or exit at any stop.
 */
public class BusRoutes {
    /**
     * Calculates the minimum number of buses needed to reach the target stop from the source stop.
     * Uses BFS (Breadth-First Search) to explore bus routes level by level.
     * 
     * Algorithm:
     * 1. Build a map of bus stops to the buses that serve them
     * 2. Use BFS starting from the source stop
     * 3. For each stop, explore all buses that serve it
     * 4. For each bus, explore all stops it serves
     * 5. Track visited buses and stops to avoid cycles
     * 
     * @param routes 2D array where routes[i] represents all stops served by bus i
     * @param source the starting bus stop
     * @param target the destination bus stop
     * @return the minimum number of buses to take, or -1 if impossible
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, Set<Integer>> busStops = new HashMap<>();

        for(int i =0;i<routes.length;i++){
            for(int stop: routes[i]){
                busStops.putIfAbsent(stop, new HashSet<>());
                busStops.get(stop).add(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        queue.offer(new int[]{source, 0});
        visitedStops.add(source);   

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int stop = curr[0];
            int busesTaken = curr[1];

            if(stop == target){
                return busesTaken;
            }

            if(!busStops.containsKey(stop)){
                continue;
            }
            
            for(int nextBus: busStops.get(stop)){
                if(visitedBuses.contains(nextBus)){
                    continue;
                }

                visitedBuses.add(nextBus);

                for(int nextStop: routes[nextBus]){
                    if(!visitedStops.contains(nextStop)){
                        visitedStops.add(nextStop);
                        queue.offer(new int[]{nextStop, busesTaken + 1});
                    }
                }
            }
        }

        return -1;
    }
}
