package com.Target.Product.Practice001;

public class BinarySearch {
	public static void main(String[] args) {
		int nums[] = {23, 45, 65, 12, 78, 98, 34};
		int target = 78;
		
		findTarget(nums, target);
	}
	
	public static void findTarget(int[] nums, int target) {
		int n = nums.length - 1;
		
		int left = 0;
		int right = n;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] == target) {
				System.out.println(nums[mid]+" Tagtet on index "+mid);
				return;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		
		System.out.println(" Not found Target "
				+ "");
	}
}
