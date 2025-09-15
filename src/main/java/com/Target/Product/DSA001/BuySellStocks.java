package com.Target.Product.DSA001;

public class BuySellStocks {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		maxProfitPerDay(prices);
	}
	
	// tc = O(n) and O(1)
	public static void maxProfitPerDay(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}else {
				maxProfit = Math.max(maxProfit, prices[i] - min);
			}
		}
		
		System.out.println(" maxProfit : "+maxProfit);
	}
}
