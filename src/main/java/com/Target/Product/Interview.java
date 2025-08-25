package com.Target.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. 
If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has 
a frequency of 3.

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in 
decreasing order.
Invitation:Round 1 || SSE Backend || NoBroker

*/

public class Interview {
	public static void main(String[] args) {
		
		int[] nums = {1, 1, 2, 2, 2, 3};  // [3,1,1,2,2,2]  working
		//int[] nums = {2, 3, 1, 3, 2};   // [1,3,3,2,2]
		
		IncreasingOrderFreq(nums);
		
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		System.out.println(" freq : "+map);
		
		
		
		  Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		  
		  Arrays.sort(arr, (a, b) -> { 
			  
			  int a1 = map.get(a); 
			  int b1 = map.get(b);
		  
			 if(a1 == b1) { 
				 return Integer.compare(b, a); 
			 
			 }
		  
		  return Integer.compare(a1, b1); });
		  
		  System.out.println(" Ans : "+ Arrays.toString(arr));
		 
				
	}
	
	
	public static void  IncreasingOrderFreq(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		System.out.println(" freq : "+map);
		
		Map<Integer, List<Integer>> freqGroup = new HashMap<>();
		
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			
			int a1 = entry.getKey();
			int b1 = entry.getValue();
			
			freqGroup.putIfAbsent(b1, new ArrayList<>());
			freqGroup.get(b1).add(a1);
		}
		
		
		int[] arr = new int[n];
		for(Map.Entry<Integer, List<Integer>> entries : freqGroup.entrySet())
		{
			List<Integer> entry = entries.getValue();
			
			
			
			
			
		}
		
		System.out.println(" Group Frequency  -- "+ freqGroup);
	}
}
