package com.Target.Product.Java;

public class StringEqualsExasmple {
	public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = new String("hello");
		String s3 = "hello";
		
		
		System.out.println(s1 == s3); // false;
		System.out.println(s1.equals(s2.intern())); // true;
	}
}
