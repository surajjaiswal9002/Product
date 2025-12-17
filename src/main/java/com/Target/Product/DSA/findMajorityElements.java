package com.Target.Product.DSA;

public class findMajorityElements {
	public static void main(String[] args) {
		 int[] nums = {1, 2, 3, 2, 2, 2, 5, 2};
		 int majorities = findMajoritiesEle(nums);
		 
		 System.out.println(" Majaroties : "+majorities);
	}
	
	
	// O(n) and O(1)
	private static int findMajoritiesEle(int[] nums) {
		int count = 0;
		int candidate = 0;
		
		for(int num : nums) {
			if(count == 0) {
				candidate = num;
			}
			
			count += (candidate == num) ? 1 : -1;
		}
		
		
		// verification step
		int freq = 0;
		for(int num : nums) {
			if(candidate == num) {
				freq++;
			}
		}
		
		return (freq > nums.length / 2) ? candidate : 0;
		
	}
}
