package com.Target.Product.onee;

public class MaxPathSumFromBottomToTop {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };

        int n = mat.length;
        int m = mat[0].length;
        int maxPathSumBottomTop = Integer.MIN_VALUE;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        for (int j = 0; j < m; j++) {
            maxPathSumBottomTop = Math.max(maxPathSumBottomTop, findMaxPathSumBottomTop(mat, dp,n - 1, j, n, m));
        }

        System.out.println(maxPathSumBottomTop);
    }

    public static int findMaxPathSumBottomTop(int[][] mat, int[][] dp, int r, int c, int n, int m) {
        if (c < 0 || c >= m) {
            return -1;
        }

        // basecase
        if (r == 0) {
            return mat[r][c];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }


        // recursion
        int up = findMaxPathSumBottomTop(mat, dp,r - 1, c, n, m);
        int upLeft = findMaxPathSumBottomTop(mat, dp,r - 1, c - 1, n, m);
        int upRight = findMaxPathSumBottomTop(mat, dp,r - 1, c + 1, n, m);

        dp[r][c] = mat[r][c] + Math.max(up, Math.max(upLeft, upRight));
        return dp[r][c];
    }
}
