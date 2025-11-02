package com.Target.Product.Practice001;



abstract class Animall {
	  String name;
	  Animall(String name) {
	    this.name = name;
	  }
	  abstract void sound();
	}

	interface Pet {
	  void play();
	}

	class Dogg extends Animall implements Pet {
	  Dogg(String name) {
	    super(name);
	  }
	  @Override
	  void sound() {
	    System.out.println(name + " barks.");
	  }
	  @Override
	  public void play() {
	    System.out.println(name + " plays fetch.");
	  }
	}

	public class InterfaceAbstractClassExample {
	  public static void main(String[] args) {
	    Dogg dog = new Dogg("Buddy");
	    dog.sound(); // Output: Buddy barks.
	    dog.play(); // Output: Buddy plays fetch.
	  }
	}

