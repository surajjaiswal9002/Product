package com.Target.Product.Java11;

public class StringMethodJava11 {
	public static void main(String[] args) {
		String str = " ";
		
		System.out.println(str.isBlank());
		//System.out.println(str.isEmpty()); 
		
		String str2 = " Java 11 ";
		
		System.out.println(str2.strip());
		System.out.println("Hi ".repeat(5));
		
		String str3 = "A\nB\nC\nD";
		
		str3.lines().forEach(System.out::println);
		
	}
	
}
