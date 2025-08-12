package com.Target.Product.onee;

public class MaximumPathSumMatrixTopBottom {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };

       // int[][] mat = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int n = mat.length;
        int m = mat[0].length;
        int maxPathSumTopBottom = Integer.MIN_VALUE;

        // Initialized the -1
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }


        for (int j = 0; j < m; j++) {
            maxPathSumTopBottom = Math.max(maxPathSumTopBottom, findMaxPathsumTopBottom(mat, dp, 0, j, n, m));
        }

        System.out.println(maxPathSumTopBottom);
    }

    public static int findMaxPathsumTopBottom(int[][] mat, int[][] dp, int r, int c, int n, int m) {
        if (c < 0 || c >= m) {
            return -1;
        }

        //basecase
        if (r == n - 1) {
            return mat[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int down = findMaxPathsumTopBottom(mat, dp, r + 1, c, n, m);
        int downLeft = findMaxPathsumTopBottom(mat, dp, r + 1, c - 1, n, m);
        int downRight = findMaxPathsumTopBottom(mat, dp, r + 1, c + 1, n, m);

        dp[r][c] = mat[r][c] + Math.max(down, Math.max(downLeft, downRight));
        return dp[r][c];
    }
}
