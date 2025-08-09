package com.Target.Product.DSA;

public class ArraySorted {
	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 7, 10, 12 };

		System.out.println(" Array is sorted : " + isSorted(arr));
	}

	// tc = o(n) and sc = O(1)
	public static boolean isSorted(int[] arr) {
		int n = arr.length;

		if (n == 0 || n == 1)
			return true;

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}

		return true;
	}
}
