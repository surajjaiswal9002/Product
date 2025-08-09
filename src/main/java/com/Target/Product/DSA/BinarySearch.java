package com.Target.Product.DSA;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int nums[] = {23, 45, 65, 12, 78, 98, 34};
		int target = 78;
		
		findTarget(nums, target);
	}
	
	// tc - O(n log n) and sc = O(1)
	public static void findTarget(int[] nums, int target) {
		
		Arrays.sort(nums);  // o(n log n);
		 
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				System.out.println(" Target : "+mid);
				return;
			}else if( nums[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
	}
}
