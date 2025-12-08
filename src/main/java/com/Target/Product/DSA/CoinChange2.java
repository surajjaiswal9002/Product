package com.Target.Product.DSA;

public class CoinChange2 {
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 5;
		
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		
		for(int coin : coins) {
			for(int i = coin; i <= amount; i++) {
				dp[i] = dp[i] + dp[i - coin];
			}
		}
		
		System.out.println(" Maximum Combination : "+dp[amount]);
	}
}
