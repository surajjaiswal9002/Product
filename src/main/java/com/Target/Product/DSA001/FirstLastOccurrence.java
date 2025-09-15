package com.Target.Product.DSA001;

public class FirstLastOccurrence {
	public static void main(String[] args) {
		int[] nums = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;
        
        findFirstAccurance(nums, target);
        findLastAccurance(nums, target);
	}
	
	
	// tc - O(log n) and sc - O(1)
	public static void findFirstAccurance(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1
				;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				ans = mid;
				high = mid - 1;
			}else if(nums[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		
		System.out.println(ans);
	}
	
	// tc - O(log n) and sc - O(1)
	public static void findLastAccurance(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1
				;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				ans = mid;
				low = mid + 1;
			}else if(nums[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		
		System.out.println(ans);
	}
}
