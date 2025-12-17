package com.Target.Product.DSA;

public class ShortestUnSortedContinuesSubArray {
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		
		int unSortedSubArray = findUnSortedSubArray(nums);
		System.out.println(" UnSorted Continues SubArray : "+unSortedSubArray);
	}
	
	// // tc O(n) and sc - O(1)
	public static int findUnSortedSubArray(int[] nums) {
		
		int n = nums.length;
		
		int left = 0;
		int right = nums.length - 1;
		
		while(left < n - 1 && nums[left] <= nums[left + 1]) {
			left++;
		}
		
		if(left == n - 1) return 0;
		
		while(right > 0 && nums[right] >= nums[right - 1]) {
			right--;
		}
		
		
		int subMin = Integer.MAX_VALUE;
		int subMax = Integer.MIN_VALUE;
		
		
		for(int i = left; i <= right; i++) {
			subMin = Math.min(subMin, nums[i]);
			subMax = Math.max(subMax, nums[i]);
		}
		
		
		while(left > 0 && nums[left - 1] > subMin) {
			left--;
		}
		
		while(right < n - 1 && nums[right + 1] < subMax) {
			right++;
		}
		
		
		return right - left + 1;
	}
}
