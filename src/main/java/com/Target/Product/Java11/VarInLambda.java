package com.Target.Product.Java11;

import java.util.*;

// Java 11 extended the use of var to lambda parameters, improving consistency and readability.
public class VarInLambda {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Suraj", "hello", "hsbc","jaiswal");
		
		 // Using 'var' in lambda parameter
		
		
		list.forEach((final var name) -> System.out.println(name.toUpperCase()));
		///Allows modifiers like final with lambda parameters and improves code uniformity.
	}
}
