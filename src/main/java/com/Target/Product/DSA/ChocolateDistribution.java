package com.Target.Product.DSA;

import java.util.Arrays;

public class ChocolateDistribution {
	public static void main(String[] args) {
		
		int[] students = {1,1,2,2,3,3};
		
		isMinChocolateDist(students);
	}
	
	public static void isMinChocolateDist(int[] ranks) {
		int n = ranks.length;
		int[] chocolatesDist = new int[n];
		
		
		//Step 1-  given each student 1 chocolate.
		for(int i = 0; i < n; i++) {
			chocolatesDist[i] = 1;
		}
		
		// Step 2  give min chocolate from left to right
		for(int i = 1; i < n; i++) {
			if(ranks[i] < ranks[i - 1]) {
				chocolatesDist[i] = chocolatesDist[i - 1] + 1;
			}
		}
		
		
		System.out.println(" Total Chocolate chocolatesDist : "+Arrays.toString(chocolatesDist));
		
		// step 3 given chocolate from right to left 
		for(int i = n - 2; i >= 0; i--) {
			if(ranks[i] < ranks[i + 1]) {
				chocolatesDist[i] = Math.max(chocolatesDist[i], chocolatesDist[i + 1] + 1);
			}
		}
		
		
		// step 4: total chocolate
		int totalChocolateDist = 0;
		for(int c : chocolatesDist) {
			totalChocolateDist += c;
		}
		
		
		System.out.println(" Student chocolate distributed : "+Arrays.toString(chocolatesDist));
		System.out.println(" Total Chocolate Distribution : "+totalChocolateDist);
	}
}
