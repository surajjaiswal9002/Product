package com.Target.Product.DSA;

import java.util.Arrays;

public class UniquePath {
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		// output = 28
		
		int ans = findUniquePath(m, n);
		System.out.println(" unique Path : "+ans);
			
	}
	
	// Tc - O(n * m) and sc - O(n)
	public static int findUniquePath01(int m, int n) {
	    int[] dp = new int[n];
	    Arrays.fill(dp, 1);
	    
	    for (int i = 1; i < m; i++) {
	        for (int j = 1; j < n; j++) {
	            dp[j] += dp[j - 1];
	        }
	    }
	    return dp[n - 1];
	}

	
	// Tc - O(n * m) and sc - O(n * m)
	public static int findUniquePath(int m, int n) {
		int[][] dp = new int[m][n];
		
		//Arrays.fill(dp[0], 1);

		for(int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		
		
		
		for(int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		
		
		return dp[m-1][n-1];
	}
}
