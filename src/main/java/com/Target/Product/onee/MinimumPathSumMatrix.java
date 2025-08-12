package com.Target.Product.onee;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;

public class MinimumPathSumMatrix {
    public static void main(String[] args) {

        int[][] mat = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        findMinPathSum(mat);
    }

    public static void findMinPathSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dp = new int[n];
        dp[0] = mat[0][0];

        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + mat[0][j];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + mat[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = mat[i][j] + Math.max(dp[j], dp[j - 1]);
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println("Minimum Path sum : " + dp[m - 1]);
    }

}
