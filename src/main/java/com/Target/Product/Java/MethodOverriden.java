package com.Target.Product.Java;


class Animal{
	
	 void makeSound() {
		System.out.println(" Generic Sound ");
	}
}

class Dog extends Animal{
	
	@Override
	 void makeSound() {
		System.out.println(" Dog is making noise ");
	}
}


class Cat extends Animal{
	
	@Override
	 void makeSound() {
		System.out.println(" Cat is making noise ");
	}
}

public class MethodOverriden {
	
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Dog();
		Animal a3 = new Cat();
		
		a1.makeSound();
		a2.makeSound();
		a3.makeSound();
	}
	
}
