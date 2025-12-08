package com.Target.Product.DSA;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = {1,2,5}; 
		int amount = 11;
		
		int res = findCoinChange(coins, amount);
		System.out.println(res);
	}
	
	// tc - O(n * amount) ans sc - O(amount)
	public static int findCoinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp,  amount + 1);
		dp[0] = 0;
		
		for(int i = 1; i <= amount; i++) {
			for(int coin : coins) {
				if(i >= coin) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
					System.out.println(dp[i]);
				}
			}
		}
		
		
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
