package com.Target.Product.Java;

public class FinallyExample {
	public static void main(String[] args) {

		try {
			System.out.println(" Try block ");
			// System.exit(0); // -- finally block will not execute
		} catch (Exception e) {
			System.out.println(" Catch block ");
		} finally {
			System.out.println(" Finally block ");
		}
	}
}
