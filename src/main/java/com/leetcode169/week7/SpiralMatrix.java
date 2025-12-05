package com.leetcode169.week7;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Returns the elements of a 2D matrix in spiral order (clockwise from outside to inside).
     * 
     * The method traverses the matrix layer by layer:
     * 1. Left to right along the top row
     * 2. Top to bottom along the right column
     * 3. Right to left along the bottom row (if not already visited)
     * 4. Bottom to top along the left column (if not already visited)
     * 
     * @param matrix a 2D integer array representing the input matrix (m x n)
     * @return a List of integers containing all matrix elements in spiral order
     * 
     * @throws ArrayIndexOutOfBoundsException if matrix is empty or null
     * 
     * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
     * Space Complexity: O(1) excluding the output list
     * 
     * Example:
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (result.size() < m * n) {
            // traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // traverse from right to left
            if (top != bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;

            // traverse from bottom to top
            if (left != right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;

    }



}
