package com.Target.Product.Practice001;

import java.util.Arrays;

public class RotateArrayUsingKSteps {
	public static void main(String[] args) {
		
		 int[] arr = {1,2,3,4,5,6,7};
		 
		 rotate(arr, 3);
		 
		 System.out.println(" rotate : "+Arrays.toString(arr));
	}
	
	public static void rotate(int[] arr, int k) {
		int n = arr.length;
		
		k = k % n;
		
		swap(arr, 0, n - 1);
		swap(arr, 0, k-1);
		swap(arr, k, n-1);
	}
	
	public static void swap(int[] arr, int s, int e) {
		
		while(s < e) {
			arr[s] ^= arr[e];
			arr[e] ^= arr[s];
			arr[s] ^= arr[e];
			
			++s;
			--e;
		}
	}
}
