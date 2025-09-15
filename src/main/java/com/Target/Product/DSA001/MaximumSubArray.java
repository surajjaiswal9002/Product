package com.Target.Product.DSA001;

public class MaximumSubArray {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		maxSubArray(nums);
	}
	
	
	// O(n) anmd sc - O(1)
	public static void maxSubArray(int[] nums) {
		int currmax = 0;
		int maxSubArr = nums[0];
		
		for(int i = 0; i < nums.length; i++) {
			currmax = Math.max(nums[i], currmax + nums[i]);
			maxSubArr = Math.max(currmax, maxSubArr);
			
			if(currmax < 0) {
				currmax = 0;
			}
		}
		
		
		System.out.println(maxSubArr);
	}
}
