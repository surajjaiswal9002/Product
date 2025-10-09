package com.Target.Product.DSA;

public class BuyAndSellStock {
	public static void main(String[] args) {
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		maxProfit(prices);
	}
	
	// Tc - O(n) and sc - O(1)
	public static void maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		int n = prices.length;
		
		for(int i = 0; i < n; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}else {
				maxProfit = Math.max(maxProfit, prices[i] - min);
			}
		}
		
		System.out.println(" Buy and Sell Stock - Max Profit : "+maxProfit);
		
	}
}
