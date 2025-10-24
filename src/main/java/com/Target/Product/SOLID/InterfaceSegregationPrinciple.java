package com.Target.Product.SOLID;

//Clients should not be forced to depend on interfaces they do not use.

//Key Idea: Split large interfaces into smaller, specific interfaces.

//Prevents “fat interfaces” that contain methods unrelated to some clients.


//Small, focused interfaces
interface CardPayment {
    void payWithCard(double amount);
}

interface UPIPayment {
    void payWithUPI(double amount);
}

interface WalletPayment {
    void payWithWallet(double amount);
}

// Implement only relevant interfaces
class CashPayment {
    void payWithCash(double amount) {
        System.out.println("Paid $" + amount + " with cash");
    }
}

class CreditCardPaymentt implements CardPayment {
    public void payWithCard(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card");
    }
}

class Phonepay implements UPIPayment, WalletPayment {
    public void payWithUPI(double amount) {
        System.out.println("Paid $" + amount + " via UPI using Google Pay");
    }

    public void payWithWallet(double amount) {
        System.out.println("Paid $" + amount + " via Google Pay Wallet");
    }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        // Different payment modes
        CashPayment cash = new CashPayment();
        cash.payWithCash(100);

        CreditCardPaymentt card = new CreditCardPaymentt();
        card.payWithCard(250);

        Phonepay gpay = new Phonepay();
        gpay.payWithUPI(300);
        gpay.payWithWallet(150);
    }
}



