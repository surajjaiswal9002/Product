package com.Target.Product.onee;


import java.util.Arrays;
import java.util.OptionalInt;

public class BestTime {
 
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.     *
     * You want to maximize your profit by choosing a single day to buy one stock and
     * choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction.
     * If you cannot achieve any profit, return 0.
     * <p>
     * Example 1:
     * <p>
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     **/
	
	
	
	
	// Requirement 2 
	
	/**
	 * Design system using Core java OOPS concepts.
	 * --> A Manager can have people working under them. These people can be other managers or regular employees.
	 * --> An Employee cannot have anyone working under them.
	 * --> A Manager should be able to send a message to everyone who works under them.
	 */
 
    public int maxProfit(int[] prices) {
    	int n = prices.length;
    	int min = Integer.MAX_VALUE;
    	int maxProf = 0;
    	
    	for(int i = 0; i < n; i++) {
    		if(prices[i] < min) {  
    			min = prices[i];
    		}else {
    			maxProf = Math.max(maxProf, prices[i] - min);
    		}
    	}
    	
    	
        return maxProf;

    }
 
    public static void main(String[] args) {
        int[] prices = {7, 8, 1, 5, 3, 6, 4};
 
        BestTime bestTime = new BestTime();
        int maxProf = bestTime.maxProfit(prices);
        System.out.println(maxProf);
    }
    
    

}





