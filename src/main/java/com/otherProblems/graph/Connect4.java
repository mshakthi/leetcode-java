package com.otherProblems.graph;
import java.util.Arrays;

public class Connect4 {
    private final int rows;
    private final int cols;
    private final char[][] board;
    private final int[] heights; // next available row from bottom for each col
    private int moves;

    public static final char EMPTY = '.';

    public Connect4(int rows, int cols) {
        if (rows < 4 || cols < 4) {
            throw new IllegalArgumentException("Connect4 needs at least 4 rows and 4 cols.");
        }
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        for (char[] row : board) Arrays.fill(row, EMPTY);

        this.heights = new int[cols];
        Arrays.fill(this.heights, rows - 1);
        this.moves = 0;
    }

    /**
     * Drops a piece into a column.
     * @param col column index [0..cols-1]
     * @param player token like 'R' or 'Y'
     * @return int[]{row, col} where it landed
     * @throws IllegalArgumentException if col invalid or column full
     */
    public int[] drop(int col, char player) {
        if (col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid column: " + col);
        }
        int row = heights[col];
        if (row < 0) {
            throw new IllegalArgumentException("Column is full: " + col);
        }

        board[row][col] = player;
        heights[col]--;
        moves++;

        return new int[]{row, col};
    }

    public boolean isWinningMove(int row, int col, char player) {
        // 4 directions: horizontal, vertical, diag1 (\), diag2 (/)
        return countConnected(row, col, player, 0, 1) >= 4 ||  // →
               countConnected(row, col, player, 1, 0) >= 4 ||  // ↓
               countConnected(row, col, player, 1, 1) >= 4 ||  // ↘
               countConnected(row, col, player, 1, -1) >= 4;   // ↙
    }

    // Counts contiguous pieces including (row,col) in both +dir and -dir.
    private int countConnected(int row, int col, char player, int dr, int dc) {
        int total = 1; // include the last placed piece

        // forward direction
        total += countOneDirection(row, col, player, dr, dc);
        // backward direction
        total += countOneDirection(row, col, player, -dr, -dc);

        return total;
    }

    private int countOneDirection(int row, int col, char player, int dr, int dc) {
        int r = row + dr;
        int c = col + dc;
        int cnt = 0;

        // We only need up to 3 steps in each direction for Connect 4
        for (int steps = 0; steps < 3; steps++) {
            if (r < 0 || r >= rows || c < 0 || c >= cols) break;
            if (board[r][c] != player) break;
            cnt++;
            r += dr;
            c += dc;
        }
        return cnt;
    }

    public boolean isDraw() {
        return moves == rows * cols;
    }

    public char getCell(int r, int c) {
        return board[r][c];
    }

    public void printBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        // column indices
        for (int c = 0; c < cols; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // --- Simple demo main (optional) ---
    public static void main(String[] args) {
        Connect4 game = new Connect4(6, 7);
        char[] players = {'R', 'Y'};
        int turn = 0;

        int[][] moves = {
            {3}, {3}, {2}, {2}, {1}, {1}, {0} // R wins horizontally on bottom row
        };

        for (int[] mv : moves) {
            char p = players[turn % 2];
            int col = mv[0];
            int[] pos = game.drop(col, p);
            System.out.println("Player " + p + " -> col " + col);
            game.printBoard();

            if (game.isWinningMove(pos[0], pos[1], p)) {
                System.out.println("Player " + p + " wins!");
                return;
            }
            if (game.isDraw()) {
                System.out.println("Draw!");
                return;
            }
            turn++;
        }
    }
}
