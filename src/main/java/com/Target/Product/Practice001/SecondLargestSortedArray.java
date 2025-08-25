package com.Target.Product.Practice001;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestSortedArray {
	public static void main(String[] args) {
		
		int[] arr = {12, 35, 1, 10, 34, 1};
		
		int n = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
		
		System.out.println(n);
		
	}
}
