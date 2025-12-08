package com.Target.Product.Gold;

import java.util.*;


public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15, 7};
		int target = 9;
		
		int[] ans = findTwoSum(nums, target);
		
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] findTwoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		
		for(int i = 0; i < n; i++) {
			int curr = target - nums[i];  // 9 - 7`
			
			
			if(map.containsKey(curr)) {
				return new int[] {map.get(curr), curr};
			}
			
			map.put(nums[i], curr);
		}
		
		
		
		return new int[] {-1, -1};
	}
}
