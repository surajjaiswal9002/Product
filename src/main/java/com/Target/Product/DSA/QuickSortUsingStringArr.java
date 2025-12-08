package com.Target.Product.DSA;

import java.util.Arrays;

public class QuickSortUsingStringArr {
	public static void main(String[] args) {
		String[] words = {"apple", "banana", "apple", "dog", "cat", "banana", "apple", "elephant", "dog"};

		quickSort3WayPartition(words, 0, words.length - 1);
		System.out.println("Sorted: " + Arrays.toString(words));
	}
	
	
	// 3-way QuickSort for Strings
	public static void quickSort3WayPartition(String[] arr, int start, int end) {
		if (start >= end) return;

		String pivot = arr[start];
		int low = start;
		int mid = start + 1;
		int high = end;

		while (mid <= high) {
			/// current logic is ascending order, 
			//if I want to change in descending order then if(nums[mid] > pivot)
			int cmp = arr[mid].compareTo(pivot);
			if (cmp < 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (cmp == 0) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
		}

		quickSort3WayPartition(arr, start, low - 1);
		quickSort3WayPartition(arr, high + 1, end);
	}
	
	public static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
