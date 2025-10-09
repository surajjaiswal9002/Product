package com.Target.Product.DSA002;

public class Candy {
	public static void main(String[] args) {
		int[] ratings = {1, 2, 2};
		
		totalCandy(ratings);
	}
	
	
	// tc - O(n) & sc - O(n)
	public static void totalCandy(int[] ratings) {
		int n = ratings.length;
		int[] countCandy = new int[n];
		
		// step 1--> give 1 candy to every one
		for(int i = 0; i < n; i++) {
			countCandy[i] = 1;
		}
		
		// step 2 -- left to right candy
		for(int i=1; i< n; i++) {
			if(ratings[i] > ratings[i - 1]) {
				countCandy[i] = countCandy[i - 1] + 1;
			}
		}
		// step 3 -- right to left
		for(int i = n - 2; i >= 0; i--) {
			if(ratings[i] > ratings[i + 1]) {
				countCandy[i] = Math.max(countCandy[i], countCandy[i + 1] + 1);
			}
		}
		
		// step 4 -- find total and return
		int totalCandy = 0;
		for(int c : countCandy) {
			totalCandy += c;
		}
		
		System.out.println(" total Candy : "+totalCandy);
	}
}
