package com.Target.Product.DSA;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum {
	public static void main(String[] args) {
		 int[] arr = {10, 5, 2, 7, 1, 9};
	        int k = 15;
	        
	     System.out.println(" Maximum SubArray with sum = k length : "+maxSubArraySum(arr, k));
	}
	
	public static int maxSubArraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLen = 0;
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if(sum == k) {
				maxLen = i + 1;
			}
			
			if(map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			}
			
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		
		return maxLen;
	}
}
