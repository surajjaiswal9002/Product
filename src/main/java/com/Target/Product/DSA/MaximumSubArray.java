package com.Target.Product.DSA;

public class MaximumSubArray {

	public static void main(String[] args) {
		
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		int ans = maxSubArray(nums);
		System.out.println(" Maximum SubArray Sum : "+ans);

	}
	
	// Tc - O(n) and sc - O(1) using Kadane's Algo
	public static int maxSubArray(int[] nums) {
		int maxArr = nums[0];
		int currMax = 0;
		
		for(int i = 0; i < nums.length; i++) {
			currMax = Math.max(nums[i], currMax + nums[i]);
			maxArr = Math.max(maxArr, currMax);
			
			if(currMax < 0) {
				currMax = 0;
			}
		}
		
		return maxArr;
	}

}
