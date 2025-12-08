package com.Target.Product.Java.java8;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.*;

public class PredicateExample {
	public static void main(String[] args) {
		Predicate<Integer> isEven = n -> n % 2 == 0;
		
		System.out.println(" Is Even : "+isEven.test(9));
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream().filter(isEven).forEach(System.out::println)
		;
	}
}
