package com.otherProblems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMinEffort {
    /**
     * Calculates the minimum effort required to travel from the top-left corner to the bottom-right corner
     * of a 2D grid, where the effort between two adjacent cells is defined as the absolute difference in their heights.
     * The path's effort is the maximum effort among all the steps in the path.
     *
     * This method uses a modified BFS approach to find the path with the minimum possible maximum effort.
     *
     * @param heights a 2D integer array representing the heights of each cell in the grid
     * @return the minimum effort required to travel from (0, 0) to (m-1, n-1)
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        effort[0][0] = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for(int[] dir: directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int currentEffort = Math.max(effort[x][y], Math.abs(heights[newX][newY] - heights[x][y]));
                    if(currentEffort < effort[newX][newY]) {
                        effort[newX][newY] = currentEffort;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return effort[m - 1][n - 1];
        
    }
}
