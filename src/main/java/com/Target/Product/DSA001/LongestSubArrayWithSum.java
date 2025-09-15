package com.Target.Product.DSA001;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum {
	public static void main(String[] args) {
		 int[] arr = {10, 5, 2, 7, 1, 9};
	        int k = 15;
	        
	        longSubArray(arr, k);
	}
	
	
	// tc = O(n) and sc -O(n)
	public static void longSubArray(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLen = 0;
		int sum= 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
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
		
		
		
		System.out.println(maxLen);
	}
}
