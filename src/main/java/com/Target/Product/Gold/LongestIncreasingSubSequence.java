package com.Target.Product.Gold;

import java.util.*;

public class LongestIncreasingSubSequence {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		
		findLIS(nums);
	}
	
	public static void findLIS(int[] nums) {
		
		List<Integer> res = new ArrayList<>();
		
		for(int num : nums) {
			if(res.isEmpty() || res.get(res.size() - 1) < num) {
				res.add(num);
			}else {
				int idx = binarySearch(res, num);
				res.set(idx, num);
			}
		}
		
		System.out.println(res);
	}
	
	public static int binarySearch(List<Integer> res, int target) {
		int start = 0;
		int end = res.size() - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(res.get(mid) == target) {
				return mid;
			}else if(res.get(mid) < target) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		
		return start;
	}
}
