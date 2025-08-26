package com.Target.Product.Practice001;

import java.util.HashSet;
import java.util.Set;

public class FindDublicate {
	public static void main(String[] args) {
		
		int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
		
		dublicate(arr);
	}
	
	public static void dublicate(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> doblicateList = new HashSet<Integer>();
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(!set.add(arr[i])) {
				doblicateList.add(arr[i]);
			}
		}
		
		System.out.println(" set : "+set);
		System.out.println(" dublicate : "+doblicateList);
	}
}
