package com.Target.Product.DSA;

public class Factorial {
	public static void main(String[] args) {
		int n  = 5;
		
		factorial(n);
		int ans = recrsionFactorial(n);
		System.out.println(" Recursion "+ "factorial : "+ans);
		
	}
	
	// tc O(n) and sc - O(n) due to recursion;
	public static int recrsionFactorial(int n) {
		if( n == 1) {
			return n;
		}
		
		
		return n * recrsionFactorial(n - 1);
		
	}
	
	// tc O (n) and sc - O(1)
	public static void factorial(int n ) {
		int fact = 1;
		
		for(int i = 1; i <= n; i++) {
			fact *= i;
		}
		
		System.out.println(" factorial : "+fact);
	
	}
}
