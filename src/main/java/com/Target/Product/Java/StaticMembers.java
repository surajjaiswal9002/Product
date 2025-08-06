package com.Target.Product.Java;

public class StaticMembers {
	
	// static block
	static {
		System.out.println(" static block example. ");
	}
	
	
	// static varibale
	static String name = "suraj jaiswal";
	
	
	// static method
	static void display(String name) {
		System.out.println(" name : "+ name);
	}
	
	
	public static void main(String[] args) {
		System.out.println(name);   // calling static static variable with-in the class
		display("Suraj jaiswal");    // calling static static method with-in the class 
	}
}
