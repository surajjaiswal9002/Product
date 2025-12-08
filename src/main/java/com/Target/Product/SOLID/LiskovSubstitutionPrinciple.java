package com.Target.Product.SOLID;


/// objects of a superclass should be replaceable with objects of a subclass 
///without brekling the behaviour of program.

//Base class with only shared behavior
abstract class Bird {
 abstract void eat();
}

//FlyingBird subclass
abstract class FlyingBird extends Bird {
 abstract void fly();
}

//Concrete Birds
class Sparrow extends FlyingBird {
 void fly() { System.out.println("Sparrow flying"); }
 void eat() { System.out.println("Chirp"); }
}

class Penguin extends Bird {
 void eat() { System.out.println("Squawk"); }
}

//Usage

public class LiskovSubstitutionPrinciple {
 public static void main(String[] args) {
     FlyingBird sparrow = new Sparrow();
     sparrow.fly(); // works
     sparrow.eat(); // works

     Bird penguin = new Penguin();
     penguin.eat(); // works
     // penguin.fly(); → Not allowed, correctly separated
 }
}

