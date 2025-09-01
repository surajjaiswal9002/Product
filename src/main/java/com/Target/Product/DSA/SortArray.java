package com.Target.Product.DSA;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		
		int[] nums = {5, 1, 5, 2, 1, 2, 0, 3};
		
		int[] ans = sortArr(nums);
		
		System.out.println(" Sort in ascending order : "+Arrays.toString(ans));
	}
	
	
	// tc - O(n) and sc - O(n)
	public static int[] sortArr(int[] nums) {
		int n = nums.length;
		
		// step 1 - max number find
		int max = Integer.MIN_VALUE;
		for(int num : nums) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println(" Maximum Number : "+max);
		
		// step - 2 create new array and store al the value
		int[] count = new int[max+1];
		for(int i = 0; i < n; i++) {
			count[nums[i]]++;
		}
		
		System.out.println(" Count array : "+Arrays.toString(count));
		
		// step - 3 to store int asc order
		int index = 0;
		for(int i = 0; i < count.length; i++) {
			while(count[i] > 0) {
				nums[index++] = i;
				count[i]--;
			}
		}
		
		
		return nums;
	}
	
	
}
