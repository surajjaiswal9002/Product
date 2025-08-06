package com.Target.Product.Java;


// Example of Method Overloading 
public class MethodOverloading {
	
	public void display(int age) {
		System.out.println(" age : "+age);
	}
	
	public void display(String name) {
		System.out.println(" name : "+name);
	}
	
	public void display(String name, int age) {
		System.out.println(" name : "+name+" age : "+age);
	}
	
	
	public static void main(String[] args) {
		MethodOverloading m1 = new MethodOverloading();
		m1.display(27);
		m1.display("Suraj jaiswal");
		m1.display("Suraj jaiswal", 27);
	}
}
