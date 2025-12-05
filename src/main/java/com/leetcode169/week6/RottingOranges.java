package com.leetcode169.week6;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    /**
     * Calculates the minimum number of minutes required for all fresh oranges to rot.
     * 
     * This method uses BFS (Breadth-First Search) to simulate the rotting process.
     * Starting from all initially rotten oranges (value 2), it spreads the rot to
     * adjacent fresh oranges (value 1) in all four directions (up, down, left, right).
     * 
     * @param grid a 2D integer array where:
     *             - 0 represents an empty cell
     *             - 1 represents a fresh orange
     *             - 2 represents a rotten orange
     * @return the minimum number of minutes until no fresh oranges remain.
     *         Returns -1 if it's impossible to rot all fresh oranges.
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                } else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

            }
        }

        int minutes = 0;

        while(!queue.isEmpty() && freshOranges >0){
            int size = queue.size();

            for(int i =0;i<size;i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] dir: directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(isValidCell(newRow, newCol, grid)){
                        grid[newRow][newCol] =2;
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;

        }

        return freshOranges ==0 ? minutes : -1;

    }

    public boolean isValidCell(int row, int col, int[][] grid){
        return row >=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] ==1;
    }

}
