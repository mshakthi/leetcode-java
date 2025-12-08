package com.leetcode169.week10;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '*'){
                    queue.offer(new int[]{i, j, 0});
                    grid[i][j] = 'X'; // mark as visited
                    break;
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int step = 0;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            step = cell[2];

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 'X'){
                    continue;
                }

                if(grid[newRow][newCol] == '#'){
                    return step + 1;
                }

                queue.offer(new int[]{newRow, newCol, step + 1});
                grid[newRow][newCol] = 'X'; // mark as visited
            }
        }
        
        return -1;
    }
    
}
