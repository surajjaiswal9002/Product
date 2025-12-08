package com.Target.Product.DSA;

public class ShortestSubArray1574 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,10,4,2,3,5};
		
		int ans = findLengthOfShortestSubArray(arr);
		System.out.println(" result : "+ans);
	}
	
	public static int findLengthOfShortestSubArray(int[] arr) {
		int n = arr.length;
		
		// find sorted prefix
		int left = 0;
		while(left < n-1 && arr[left] < arr[left + 1]) {
			left++;
		}
		
		// check if sorted
		if(left == n- 1) {
			return 0;
		}
		// find sorted sufix
		int right = n - 1;
		while(right > 0 && arr[right - 1] <= arr[right]) {
			right--;
		}
		
		// min
		int result = Math.min(n - left - 1, right);
		
		// using 2 pointer find combination 
		int i = 0; int j = right;
		while(i <= left && j < n) {
			if(arr[i] <= arr[j]) {
				result = Math.min(result, j - i - 1);
				i++;
			}else {
				j++;
			}
		}
		
		return result;
	}
}
