package com.Target.Product.DSA002;

import java.util.*;

public class PascalTraingle {
	public static void main(String[] args) {
		
		int n = 6;
		
		List<List<Integer>> result = generatePT(n);
		
		for(List<Integer> r : result) {
			System.out.println(r);
		}
		
		System.out.println();
	}
	
	public static List<List<Integer>> generatePT(int n){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < n; i++) {
			List<Integer> rowList = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					// first and last value = 1;
					rowList.add(1);
				}else {
					rowList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
				}
			}
			
			list.add(rowList);
		}
		
		return list;
	}
}	
