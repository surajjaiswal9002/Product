package com.Target.Product.DSA;

public class SortArrayDutchNationalFlag {
	public static void main(String[] args) {
		int[] nums = {2, 0, 1, 1,0, 2};
		
		sortColor(nums);
		
		for(int n : nums) {
			System.out.println("-- "+n);
		}
	}
	
	
	// Tc - O(n) and SCc = O(1)
	public static void sortColor(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		
		
		while(mid <= high) {
			if(nums[mid] == 0) {
					swap(nums, low, mid);
					low++;
					mid++;
			}else if(nums[mid] == 1) {
					mid++;
			}else {
				swap(nums, mid, high);
				high--;
					
			
					
			}
		}
	
	}
	
	public static void swap(int[] nums, int s, int e) {
		int temp = nums[s];
		nums[s] = nums[e];
		nums[e] = temp;
	}
}
