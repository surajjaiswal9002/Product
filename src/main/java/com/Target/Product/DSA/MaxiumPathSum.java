package com.Target.Product.DSA;

import java.util.Arrays;

public class MaxiumPathSum {
	public static void main(String[] args) {
		int[][] grid = {{1, 2, 3}, {9, 8, 7}, {4, 5, 6}};
		
		findMaxPathSum(grid);
	}
	
	public static void findMaxPathSum(int[][] grid) {
		int n = grid.length;
		
		int[] dp = new int[n];
		
		for(int j = 0; j < n; j++) {
			dp[j] = grid[0][j];
		}
		
		
		for(int i = 1; i < n; i++) {
			int[] newDp = new int[n];
			for(int j = 0; j < n; j++) {
				int up = dp[j]; 
				int leftDig = (j > 0) ? dp[j - 1] : 0;
				int rightDig = (j < n - 1) ? dp[j + 1] : 0;
				
				newDp[j] = grid[i][j] + Math.max(up, Math.max(leftDig, rightDig));
			}
			
			dp = newDp;
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(" Maxium Path Sum : "+ ans);
		
	}
}
