package com.Target.Product.DSA001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// tc - O(On log n) and sc - O(n)
public class LongestIncreasingSubSequence {
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		
		int lis = longestLIS(nums);
		System.out.println(" Longest Increaseing SubSequence : "+lis);
	}
	
	public static int longestLIS(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		for(int n :  nums) {
			if(res.isEmpty() || res.get(res.size() - 1) < n) {
				res.add(n);
			}else {
				int idx = binarySearch(res, n);
				res.set(idx, n);
			}
		}
		
		System.out.println(res);
		
		return res.size();
	}
	
	public static int binarySearch(List<Integer> arr, int target) {
		int low = 0;
		int high = arr.size() - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(arr.get(mid) == target) {
				return mid;
			}else if(arr.get(mid) < target){
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		return low;
	}
	
	
}	
