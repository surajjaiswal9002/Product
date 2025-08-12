package com.Target.Product.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriplateSum {
	public static void main(String[] args) {
		
		int nums[] = { 12, 3, 4, 1, 7, 9, 8 };
		int sum = 24;
		
		List<int[]> ans = tripleSum(nums, sum);
		
		for(int[] triplate : ans)
		System.out.println(" Triple sum : "+Arrays.toString(triplate));
	}
	
	// tc- O(n2) and sc - O(K);
	public static List<int[]> tripleSum(int[] nums, int sum) {
		int n = nums.length;
		
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;
			
			while(left < right) {
				int currSum = nums[i] + nums[left] + nums[right];
				
				if(currSum == sum) {
					list.add(new int[] {nums[i], nums[left], nums[right]});
					left++;
					right--;
					//return new int[] {nums[i], nums[left], nums[right]};
				}else if(currSum < sum) {
					left++;
				}else {
					right--;
				}
			}
		}
		
		return list;
		
	}
}
