package com.Target.Product.gspdfproble;


// O(N * M) AND SC O(N)
public class MinPathSum {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int n = mat.length;
        int m = mat[0].length;

        int[] dp = new int[n];
        dp[0] = mat[0][0];

        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + mat[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = mat[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }


        System.out.println(dp[m -1]);

    }
}
