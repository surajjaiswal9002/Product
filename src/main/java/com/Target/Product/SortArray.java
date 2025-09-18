package com.Target.Product;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 4, 5, 8};
			
		sortArray(nums);
	}
	
	// Tc - O(n) ans sc - O(n)
	public static void sortArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		
		for(int num : nums) {
			if(max < num) {
				max = num;
			}
		}
		
		System.out.println(max);
		
		int[] count = new int[max+1];
		for(int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		
		int index = 0;
		for(int i = 0; i < count.length;i++) {
			while(count[i] > 0) {
				nums[index++] = i;
				count[i]--;
			}
		}
		
		
		System.out.println(" Sort Array : "+Arrays.toString(nums));
	}
}
