package com.Target.Product.DSA001;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = {4,9,4,4,8,9,1,4,7,9,3};
		
		quickSort3WayPartition(nums, 0, nums.length - 1);
		
		System.out.println(" Sort using quick sort : "+Arrays.toString(nums));
	}
	
	
	// TC - O(n log n) and tc = O(log n)
	public static void quickSort3WayPartition(int[] nums, int start, int end) {
		
		if(start >= end) return;
		
		int pivot = nums[start];  // pivot for the first element
		int low = start;
		int mid = start + 1;
		int high = end;
		
		while(mid <= high) {
			if(nums[mid] < pivot) {
				swap(nums, low, mid);
				low++;
				mid++;
			}else if(nums[mid] == pivot) {
				mid++;
			}else {
				swap(nums, mid, high);
				high--;
			}
		}
		
		// recursive call for less then pivot
		quickSort3WayPartition(nums, start, low - 1);
		// recursive call for greater than pivot
		quickSort3WayPartition(nums, high + 1, end);
	}
	
	public static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
}
