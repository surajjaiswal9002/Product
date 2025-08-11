package com.Target.Product.DSA;

import java.util.Arrays;

public class FindMediumOfSortedArr {
	public static void main(String[] args) {
		
		int[] nums1 = { 1 };
		int[] nums2 = { 3, 4 };
		
		mediumSortedArr(nums1, nums2);
	}
	
	public static void mediumSortedArr(int[] num1, int[] num2) {
		int n1 = num1.length;
		int n2 = num2.length;
		
		int[] medium = new int[n1+n2];
		
		for(int i = 0; i < n1; i++) {
			medium[i] = num1[i];
		}
		
		for(int i = 0; i < n2; i++) {
			medium[n1+i] = num2[i];
		}
		
		System.out.println(" medium : "+Arrays.toString(medium));
		 
		Arrays.sort(medium);
		int n3 = medium.length;
		int ans = 0;
		if(n3 % 2 == 0) {
			ans = (medium[n3/2] + medium[n3/2 - 1] ) / 2;
		}else {
			ans = medium[n3/2];
		}
		
		System.out.println(" medium of given arr : "+ans);
	}
}
