package com.Target.Product.Practice001;

public class SearchRoatedArray {

	public static void main(String[] args) {
		
		int[] nums = {4, 5, 6, 7, 1, 2, 3};
		int target = 5;
		int index = search(nums, target);
		
		System.out.println("Index of "+target+" is "+index);
	}
	
	public static int search(int[] nums, int target) {
		
		int low = 0, high = nums.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(nums[mid] == target) {
				return mid;
			}
			
			if(nums[low] < nums[mid]) {
				if(target >= nums[low] && target < nums[mid]) {
					high = mid - 1;			// left
				}else {
					low = mid + 1;   // right
				}
			}else {
				if(target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				}else {
					high = mid - 1;
				}
			}
		}
		
		return -1;
		
	}
}
