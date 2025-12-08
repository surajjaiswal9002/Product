package com.Target.Product.Gold;

public class MaximumPathSum {
	public static void main(String[] args) {
		int[][] mat = {{1, 2, 3}, {9, 8, 7}, {4, 5, 6}};
		
		
		int maxPathSum = findMaxPathSum(mat);
		
		System.out.println(" Max Path sum : "+maxPathSum);
	}
	
	
	public static int findMaxPathSum(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		
		
		int[] dp = new int[n];
		
		for(int j = 0; j < n; j++) {
			dp[j] = mat[0][j];
		}
		
		
		for(int i = 1; i < n; i++) {
			int[] newDp = new int[n];
			for(int j = 0; j < m; j++) {
				
				int up = dp[j];
				int leftDig = (j > 0) ? dp[j - 1] : 0;
				int rightDig = (j < n - 1) ? dp[j + 1] : 0;
				
				newDp[j] = mat[i][j] + Math.max(up, Math.max(leftDig, rightDig));
			}
			
			dp = newDp;
			
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
	}
}
