package com.Target.Product.Java.java8;

import java.util.function.Supplier;

public class SupplierExample {
	public static void main(String[] args) {
		
		Supplier<String> supplier = () -> "Hello Functional Interface";
		System.out.println(supplier.get());

	}
}
