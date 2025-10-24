package com.Target.Product.DSA;

public class FibonaSeries {
	public static void main(String[] args) {
		
		int a = 0, b = 1, c = 0;
		
		for(int i = 1; i <= 10; i++) {
			System.out.print(a+" ");
			c = a+b;
			a = b;
			b = c;
		}
		
		
		System.out.println(" ================ ");
		
		 int n = 10;  // print first 10 Fibonacci numbers

	        for (int i = 0; i < n; i++) {
	            System.out.print(fib(i) + " ");
	        }
		
		
	}
	
	
	 static int fib(int n) {
	        if (n == 0) return 0;       // base case
	        if (n == 1) return 1;       // base case
	        return fib(n - 1) + fib(n - 2);  // recurrence relation
	    }
}
