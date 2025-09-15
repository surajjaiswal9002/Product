package com.Target.Product.DSA001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int nums[] = {23, 45, 65, 12, 78, 98, 34};
		int target = 78;

		Arrays.sort(nums);
		System.out.println("nums = "+Arrays.toString(nums));
		
		
		int ans = findTarget(nums, target);
		System.out.println(" Target : "+ans);
	}
	
	
	//tc - O(log n) and sc = O(1)
	public static int findTarget(int[] nums, int target) {
		
	
		
		int low = 0;
		int high = nums.length - 1;
		
	
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		
		return -1;
	}
}
