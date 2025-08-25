package com.Target.Product.Practice001;

public class BuySellStocks {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		maxProfit(prices);
	
	}
	
	
	
	public static void maxProfit(int[] prices) {
		int n = prices.length;
		int min = Integer.MAX_VALUE;
		int maxProfitAfterDay = 0;
		
		for(int i = 0; i < n; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}else {
				maxProfitAfterDay = Math.max(maxProfitAfterDay, prices[i] - min);
			}
		}
		
		
		System.out.println(" Maximum Profit after sell : "+maxProfitAfterDay);
	}
}
