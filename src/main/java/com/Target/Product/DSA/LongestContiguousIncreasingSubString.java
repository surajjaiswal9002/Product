package com.Target.Product.DSA;

public class LongestContiguousIncreasingSubString {
	public static void main(String[] args) {
		  int[] nums = {1, 2, 2, 3, 4, 1, 5, 6};
	        int result = findLongestIncreasingSubstring(nums);
	        System.out.println("Longest Increasing Substring Length: " + result);
	}
	
	// tc - O(n) and sc - O(1)
	public static int findLongestIncreasingSubstring(int[] nums) {
		int curr = 1;
		int maxSubString = 1;
		int n = nums.length;
		
		for(int i = 1; i < n; i++) {
			if(nums[i] > nums[i - 1]) {
				curr++;
				maxSubString = Math.max(maxSubString, curr);
			}else {
				curr = 1;
			}
		}
		
		return maxSubString;
	}
}
