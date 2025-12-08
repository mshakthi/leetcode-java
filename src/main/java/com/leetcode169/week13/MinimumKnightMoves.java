package com.leetcode169.week13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    /**
     * Calculates the minimum number of moves required for a knight to reach position (x, y) from (0, 0).
     * 
     * This method uses BFS (Breadth-First Search) to find the shortest path for a knight on an infinite
     * chessboard. The knight starts at position (0, 0) and needs to reach the target position (x, y).
     * 
     * The algorithm leverages symmetry by using absolute values of coordinates, as the minimum number
     * of moves is the same for any reflected position across the axes. The search is bounded to avoid
     * going too far in negative directions (allowing only up to -2 in each dimension) while still
     * ensuring all valid paths are explored.
     * 
     * @param x the x-coordinate of the target position
     * @param y the y-coordinate of the target position
     * @return the minimum number of knight moves required to reach position (x, y) from (0, 0)
     */
    public int minKnightMoves(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        int[][] dirs = {{-2,-1}, {-2,1}, {-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        Set<String> visited = new HashSet<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited.add("0,0");

        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0;i<size;i++){
                int[] curr = queue.poll();

                if(curr[0] == absX && curr[1] == absY){
                    return moves;
                }

                for(int[] dir : dirs){
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];

                    String posKey = newX + "," + newY;
                    if(!visited.contains(posKey) && newX >= -2 && newY >= -2){
                        visited.add(posKey);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            moves++;
        }

        return moves;
        
    }
}
