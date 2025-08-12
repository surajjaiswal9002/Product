package com.Target.Product.datastructure;

public class minPathSumOfGivenMatrix {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 4, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int ans = findMaxPathSum(grid);
        System.out.println(" Max Path Sum : " + ans);
    }

    public static int findMaxPathSum(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;

        int[] dp = new int[m];
        dp[0] = cost[0][0];

        for (int i = 1; i < m; i++) {
            dp[i] = dp[i - 1] + cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + cost[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = cost[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[m - 1];
    }
}
