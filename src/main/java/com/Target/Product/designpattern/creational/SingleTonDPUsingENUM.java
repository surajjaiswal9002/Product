package com.Target.Product.designpattern.creational;

//Singleton using Enum - Best and safest way, Thread Safe, Serialization Safe, Reflection Safe
enum SingletonEnum{
	INSTANCE;
	
	void doSomeThings() {
		System.out.println(" Singleton design pattern using Enum..");
	}
}

public class SingleTonDPUsingENUM{
		
	public static void main(String[] args) {
		SingletonEnum s1 = SingletonEnum.INSTANCE;
		SingletonEnum s2 = SingletonEnum.INSTANCE;
		
		s1.doSomeThings();
		
		System.out.println(s1 == s2);
		
	}
	
}
