package com.Target.Product.Java;

public class ConstructorOverloading {

	int age;

	// Parametrized Constructor
	ConstructorOverloading(int age) {
		this.age = age;
	}
	
	// Default Constructor
	ConstructorOverloading() {
		this.age = 0;
	}
	
	public void display() {
		System.out.println(" Display : "+age);
	}
	
	public static void main(String[] args) {
		ConstructorOverloading c1 = new ConstructorOverloading();
		ConstructorOverloading c2 = new ConstructorOverloading(27);
		
		c1.display();
		c2.display();
		
	}
}
