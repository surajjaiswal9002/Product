package com.Target.Product.Java;

class MyClass{
	
	static {
		System.out.println(" Executor first ");
	}
	
	static int value = 100;
	
	MyClass(){
		System.out.println(" Constructor ");
	}
}


public class ClassLoaderExample {
	public static void main(String[] args) {
		System.out.println(MyClass.value);
		MyClass c = new MyClass();
		
	}
}
