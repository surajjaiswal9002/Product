package com.Target.Product.gspdfproble;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int last;

    Pair(int first, int last) {
        this.first = first;
        this.last = last;
    }
}


// Tc - O(n * m) and sc - O(n * m)
public class NumberofIland {
    public static void main(String[] args) {

        char[][] gridLands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int n = gridLands.length;
        int m = gridLands[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gridLands[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    bfs(i, j, n, m, gridLands, visited);
                }
            }
        }
        System.out.println(" Number of ilands are : "+count);
    }


    public static void bfs(int row, int col, int n, int m, char[][] grid, int[][] visited) {
        visited[row][col] = 1;

        //Queue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        // Directions
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, -1, 0, 1};

        while (!q.isEmpty()) {

            Pair curr = q.poll(); // poll
            int row1 = curr.first;
            int col1 = curr.last;

            for (int i = 0; i < 4; i++) {
                int nRow = row1 + dirRow[i];
                int nCol = col1 + dirCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }
}
