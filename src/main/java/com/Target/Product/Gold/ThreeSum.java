package com.Target.Product.Gold;

import java.util.*;


public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> ans = find3Sum(nums);
		
		
		System.out.println(" 3 Sum \n "+ ans);
	}
	
	
	public static List<List<Integer>> find3Sum(int[] nums){
		int n = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		
		for(int i = 0; i < n; i++) {
			
			// check dublicate i and skip
			if(i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = n - 1;
			
			while(left < right) {
				int currSum = nums[i] + nums[left] + nums[right];
				
				if(currSum == 0) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					
					// check duplicate from left and skip;
					while(left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					// check duplicate from right and skip;
					while(left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}else if(currSum < 0) {
					left++;
				}else {
					right--;
				}
			}
		}
		
		return list;
	}
}
