package com.Target.Product.SOLID;

// High-level modules should not depend on low-level modules. Both should depend on abstractions.
//Abstractions should not depend on details; details should depend on abstractions.

//Key Idea: Depend on interfaces or abstract classes, not concrete implementations.



//Abstraction
interface Payment {
 void pay(double amount);
}

//Concrete Implementations
class CreditCardPayment implements Payment {
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Credit Card");
 }
}

class GooglePay implements Payment {
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Google Pay");
 }
}

//High-level module depends on abstraction
class CheckoutService {
 private Payment payment; // depends on interface, not concrete class

 CheckoutService(Payment payment) {
     this.payment = payment;
 }

 void checkout(double amount) {
     payment.pay(amount);
 }
}

//Usage
public class DependencyInversionPrinciple {
 public static void main(String[] args) {
     Payment card = new CreditCardPayment();
     Payment upi = new GooglePay();

     CheckoutService checkout1 = new CheckoutService(card);
     checkout1.checkout(500);

     CheckoutService checkout2 = new CheckoutService(upi);
     checkout2.checkout(700);
 }
}

