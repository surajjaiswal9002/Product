package com.Target.Product.DSA;

import java.util.Arrays;

public class ProductExceptSelf {
	public static void main(String[] args) {
		 int[] nums = {1, 2, 3, 4};
		 
		 int[] results = productExceptSelf(nums);
		 
		 System.out.println(" Product Except Self : "+Arrays.toString(results));
	}
	
	
	// tc - O(n) and sc - O(n)
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		
		int[] left = new int[n];
		int[] right = new int[n];
		
		
		left[0] = 1;
		for(int i = 1; i < n; i++) {
			left[i] = left[i-1] * nums[i-1];
		}
		
		right[n - 1] = 1;
		for(int j = n - 2; j >= 0; j--) {
			right[j] = right[j+1] * nums[j+1];
		}
		
		for(int i = 0; i < n; i++) {
			nums[i] = left[i] * right[i];
		}
		
		return nums;
		
		
	}
}
