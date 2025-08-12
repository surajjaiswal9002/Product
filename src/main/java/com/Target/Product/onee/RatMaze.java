package com.Target.Product.onee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatMaze {
    public static void main(String[] args) {
        int[][] rat = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        int n = 4;

        ratDirections(rat, n);

    }

    public static void ratDirections(int[][] rat, int n) {
        int[][] vis = new int[n][n];

        for (int[] i : vis) {
            Arrays.fill(i, 0);
        }

        List<String> result = new ArrayList<>();
        if (rat[0][0] == 1) {
            findDirections(rat, 0, 0, n, vis, result, "");
        }

        System.out.println(result);
    }

    public static void findDirections(int[][] rat, int i, int j, int n, int[][] vis, List<String> result, String move) {
        if (i == n - 1 && j == n - 1) {
            result.add(move);
            return;
        }

        vis[i][j] = 1;
        // Directions
        // Down
        if (i + 1 < n && vis[i + 1][j] == 0 && rat[i + 1][j] == 1) {
            //vis[i][j] = 1;
            findDirections(rat, i + 1, j, n, vis, result, move+"D");
            //vis[i][j] = 0;
        }

        // up
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && rat[i - 1][j] == 1 ) {

            findDirections(rat, i - 1, j, n, vis, result, move+"U");
            //vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && rat[i][j + 1] == 1 ) {
            //vis[i][j] = 1;
            findDirections(rat, i, j + 1, n, vis, result, move+"R");
           // vis[i][j] = 0;
        }

        //left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && rat[i][j - 1] == 1 ) {
            //vis[i][j] = 1;
            findDirections(rat, i, j - 1, n, vis, result, move+"L");

        }

        //backtrack
        vis[i][j] = 0;


    }
}
