package com.Target.Product.SOLID;

//Clients should not be forced to depend on interfaces they do not use.

//Key Idea: Split large interfaces into smaller, specific interfaces.

//Prevents “fat interfaces” that contain methods unrelated to some clients.


//Small, focused interfaces
interface CardPayment { void payWithCard(double amount); }
interface UPIPayment { void payWithUPI(double amount); }
interface WalletPayment { void payWithWallet(double amount); }

//Implement only relevant interfaces
class CashPayment {
 void payWithCash(double amount) { System.out.println("Paid $" + amount + " with cash"); }
}

class CreditCardPayment implements CardPayment {
 public void payWithCard(double amount) { System.out.println("Paid $" + amount + " with card"); }
}

class GooglePay implements UPIPayment {
 public void payWithUPI(double amount) { System.out.println("Paid $" + amount + " via UPI"); }
}

public class InterfaceSegrationPrinciple {

}
