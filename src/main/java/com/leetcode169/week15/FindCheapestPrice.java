package com.leetcode169.week15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindCheapestPrice {

    /**
     * Finds the cheapest price from source to destination city with at most k stops.
     * Uses a modified Breadth-First Search (BFS) approach with a greedy optimization.
     * 
     * <p>This algorithm builds an adjacency list representation of the flight graph and
     * performs a BFS traversal while tracking the minimum cost to reach each city.
     * The search explores flights level by level (stops), updating the minimum price
     * whenever a cheaper route is found.</p>
     * 
     * @param n the total number of cities (nodes), numbered from 0 to n-1
     * @param flights a 2D array where each element is [from, to, price] representing
     *                a directed flight from city 'from' to city 'to' with the given price
     * @param src the source city from which to start the journey
     * @param dst the destination city to reach
     * @param k the maximum number of stops allowed (not including src and dst)
     * @return the minimum cost to travel from src to dst with at most k stops,
     *         or -1 if no such route exists
     * 
     * @throws IllegalArgumentException implicitly if n, src, or dst are invalid
     * 
     * <p>Time Complexity: O(E * k) where E is the number of flights (edges)</p>
     * <p>Space Complexity: O(n + E) for the adjacency list and auxiliary structures</p>
     * 
     * <p>Example:</p>
     * <pre>
     * int n = 3;
     * int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
     * int src = 0, dst = 2, k = 1;
     * // Returns 200 (route: 0 -> 1 -> 2)
     * </pre>
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        price[src] = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int city = curr[0];
            int stops = curr[1];
            int costSoFar = curr[2];

            if(stops > k) continue;

            for(int[] neighbor: adj.get(city)){
                int nextCity = neighbor[0];
                int cost = neighbor[1];
                int newPrice = costSoFar + cost;

                if(newPrice < price[nextCity]) {
                    price[nextCity] = newPrice;
                    queue.offer(new int[]{nextCity, stops + 1, newPrice});
                }
            }

        }


        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
    
}
