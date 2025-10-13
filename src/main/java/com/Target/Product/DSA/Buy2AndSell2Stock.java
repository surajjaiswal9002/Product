package com.Target.Product.DSA;

public class Buy2AndSell2Stock {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		
		maxProfitStock2(prices);
	}
	
	// tc - O(n) and sc - O(1)
	public static void maxProfitStock2(int[] prices) {
		int maxProfit = 0;
		int n = prices.length;
		
		for(int i = 1; i < n; i++) {
			if(prices[i] > prices[i - 1]) {
				maxProfit += maxProfit + prices[i] - prices[i - 1];
			}
		}
		
		System.out.println(maxProfit);
	}
}
