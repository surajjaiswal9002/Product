package com.Target.Product.onee;

import java.util.LinkedList;
import java.util.Queue;

class Pairs {
    int first;
    int last;

    Pairs(int first, int last) {
        this.first = first;
        this.last = last;
    }
}


public class NumberOfILands {
    public static void main(String[] args) {

        char[][] gridILands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        int n = gridILands.length;
        int m = gridILands[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gridILands[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    bfs(gridILands, visited, i, j, n, m);
                }
            }
        }
        System.out.println(" Num of ILands : " + count);
    }

    public static void bfs(char[][] grids, int[][] visited, int row, int col, int n, int m) {
        visited[row][col] = 1;
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(row, col));

        // Directions
        int[] dirRows = {-1, 0, 1, 0};
        int[] dirCols = {0, -1, 0, 1};

        while (!q.isEmpty()) {

            Pairs curr = q.poll();
            int row1 = curr.first;
            int col1 = curr.last;

            for (int i = 0; i < 4; i++) {
                int nRow = row1 + dirRows[i];
                int nCol = col1 + dirCols[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grids[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = 1;
                    q.add(new Pairs(nRow, nCol));
                }
            }
        }
    }
}
