package com.Target.Product.Gold;

import java.util.Arrays;

public class UinquePath {
	public static void main(String[] args) {
		int m = 3, n = 7;
		
		findUniquePath(m, n);
	}
	
	public static void findUniquePath(int m, int n) {
		int[] dp = new int[n];
		
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1]; 
			}
		}
		
		
		System.out.println(dp[n - 1]);
	}
}
