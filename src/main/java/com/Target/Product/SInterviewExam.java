package com.Target.Product;

import java.util.Arrays;

public class SInterviewExam {
	public static void main(String[] args) {
		
		/*
		 * input: [1,0,0,1,1,0,1,1,0,0,1,0,0]
		 * 
		 * Output: [0,0,0,0,0,0,0,1,1,1,1,1,1]
		 * 
		 * 
		 * 
		 * Move All the zeroes to left
		 * 
		 * Minimal Time Complexity
		 * 
		 * O(1) Space complexity
		 */
		
		/*
		 * input: [0,2,3,0,1,0,4,0,5,6]
		 * 
		 * Output: [0,0,0,0,2,3,1,4,5,6]
		 */
		
		
		int[] nums = {0,2,3,0,1,0,4,0,5,6};
		
		int n = nums.length; // 
		int count = n - 1;
		
		for( int i = n - 1; i > 0; i--){
			if(nums[i] != 0) {   
				nums[count--] = nums[i];
			}
		}
		
		while(count >= 0) {
			nums[count] = 0;
			count--;
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
