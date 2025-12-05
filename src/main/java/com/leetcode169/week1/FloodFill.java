package com.leetcode169.week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Performs a flood fill operation on a 2D image array starting from a given pixel.
 * 
 * This implementation uses Breadth-First Search (BFS) to change the color of the starting
 * pixel and all connected pixels of the same original color to a new color. Connected pixels
 * are those adjacent horizontally or vertically (4-directional connectivity).
 * 
 * @param image a 2D integer array representing the image where each element is a pixel color
 * @param sr the row index of the starting pixel (0-indexed)
 * @param sc the column index of the starting pixel (0-indexed)
 * @param color the new color value to fill with
 * @return the modified image array after performing the flood fill operation
 * 
 * <p>Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
 * <p>Space Complexity: O(m * n) in the worst case for the queue
 * 
 * <p>Note: If the starting pixel already has the target color, the image is returned unchanged
 * to avoid infinite loops.
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        int originalColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir: directions){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR >=0 && newR < rows && newC >=0 && newC < cols && image[newR][newC] == originalColor){
                    image[newR][newC] = color;
                    queue.add(new int[]{newR, newC});
                }
            }
        }

        return image;
        
    }
}
