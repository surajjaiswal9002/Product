package com.Target.Product.DSA001;

public class Factorial {
	public static void main(String[] args) {
		int n = 5;
		
		findFact(n);
		int ans = findFactUsingRecursion(n);
		System.out.println(ans);
	}
	
	// tc - O(n) and sc = O(1)
	public static void findFact(int n) {
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact *= i;
		}
		
		System.out.println("factorial : "+fact);
	}
	
	//recursion tc - O(n) and sc = O(n)
	public static int findFactUsingRecursion(int n){
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n * findFactUsingRecursion(n - 1);
	}
}
