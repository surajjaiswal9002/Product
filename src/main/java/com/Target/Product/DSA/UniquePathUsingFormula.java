package com.Target.Product.DSA;

public class UniquePathUsingFormula {
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		uniquePath(m, n);
	}
	
	public static void uniquePath(int m, int n) {
		long res = 1;
		
		for(int i = 1; i <= m-1; i++) {
			res = res * (n - 1 + i)/i;
		}
		
		System.out.println(" res : "+res);
	}
}
