package com.otherProblems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinarymatrix {
    /**
     * Finds the shortest path from the top-left corner to the bottom-right corner in a binary matrix.
     * The matrix consists of 0s (open cells) and 1s (blocked cells). Movement is allowed in 8 directions.
     * The path must start at (0, 0) and end at (m-1, n-1), only traversing cells with value 0.
     *
     * @param grid The binary matrix representing the grid.
     * @return The length of the shortest path, or -1 if no such path exists.
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] dist = new int[m][n];

        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }   

        dist[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for(int[] dir: directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    if(dist[x][y] + 1 < dist[newX][newY]) {
                        dist[newX][newY] = dist[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1];
    }
}
