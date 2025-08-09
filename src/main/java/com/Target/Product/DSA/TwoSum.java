package com.Target.Product.DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] ans = isTwoSum(nums, target);
		System.out.println(" two sum : " + Arrays.toString(ans));
	}

	// Tc - O(n) and sc - o(n)
	public static int[] isTwoSum(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			int first = nums[i];
			int temp = target - first;
			if(map.containsKey(temp)) {
				return new int[] {nums[i], nums[map.get(temp)]};
			}
			
			map.put(first, i);
		}
		return new int[] {-1, -1};
	}
}
