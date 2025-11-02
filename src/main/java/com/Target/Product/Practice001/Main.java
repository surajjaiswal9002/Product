package com.Target.Product.Practice001;

abstract class Animal {
	  private String secret = "Sensitive data";
	  abstract void makeSound();
	  protected String getSecret() {
	    return secret; // Controlled access to sensitive data
	  }
	}

	class Dog extends Animal {
	  @Override
	  void makeSound() {
	    System.out.println("Bark");
	    System.out.println("Accessing secret: " + getSecret());
	  }
	}

	public class Main {
	  public static void main(String[] args) {
	    Animal myDog = new Dog();
	    myDog.makeSound();
	  }
	}