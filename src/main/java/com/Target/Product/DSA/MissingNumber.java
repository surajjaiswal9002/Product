package com.Target.Product.DSA;

public class MissingNumber {
	public static void main(String[] args) {
		
		int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,};
		
		int n = nums.length;
		int expectedSum = n * (n + 1) / 2;
		
		int sumOfAllNums = 0;
		for(int num : nums) {
			sumOfAllNums += num;
		}
	
		int actualNumMissing = expectedSum - sumOfAllNums; 
		System.out.println(actualNumMissing);
		
	}
}
