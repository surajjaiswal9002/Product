package com.Target.Product.DSA001;

public class FibonaSeries {
	public static void main(String[] args) {
		int n = 10;
		
		fibonaSerice(n);
		int ans = findFibona(n);
		System.out.println(ans);
	}
	
	// tc - O(n) and sc - O(1)
	public static void fibonaSerice(int n) {
		int a = 0; int b= 1; int c = 0;
		
		for(int i = 0; i <= n; i++) {
			System.out.print(a+", ");
			c = a+b;
			b = a;
			a = c;
		}
		
		
		System.out.println(" ------- ");
	}
	// tc - O(2n) and sc - o(n)
	public static int findFibona(int n) {
		if(n == 0 ) return 0;
		if(n == 1) return 1;
		
		return findFibona(n - 1) + findFibona(n - 2);
	}
}
