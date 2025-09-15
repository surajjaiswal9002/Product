package com.Target.Product.DSA001;

import java.util.Arrays;

public class findMediumOfSortedArr {
	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = { 3, 4 };
		
		findMedian(nums1, nums2);
	}
	
	
	// O(n+m log(m+n) and O(n+n)
	public static void findMedian(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		
		int[] medium = new int[n + m];
		
		for(int i = 0; i < nums1.length; i++) {
			medium[i] = nums1[i];
		}
		
		for(int i = 0; i < nums2.length; i++) {
			medium[n + i] = nums2[i];
		}
		
		Arrays.sort(medium);
		
		int k = medium.length;
		int ans = 0;
		if(k % 2 == 0) {
			ans = (medium[k / 2] + medium[k / 2 + 1]) / 2;
		}else {
			ans = medium[k/2];
		}
		
		System.out.println(ans);
	}
}
