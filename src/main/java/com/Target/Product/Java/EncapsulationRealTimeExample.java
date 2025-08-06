package com.Target.Product.Java;


//BankAccount.java
class BankAccount {
 // private data fields (data hiding)
 private String accountNumber;
 private String accountHolderName;
 private double balance;

 // Constructor
 public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
     this.accountNumber = accountNumber;
     this.accountHolderName = accountHolderName;
     this.balance = initialBalance;
 }

 // Public getter (no setter for balance for control)
 public double getBalance() {
     return balance;
 }

 public String getAccountNumber() {
     return accountNumber;
 }

 public String getAccountHolderName() {
     return accountHolderName;
 }

 // Business logic: Deposit
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("₹" + amount + " deposited.");
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 // Business logic: Withdraw
 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         System.out.println("₹" + amount + " withdrawn.");
     } else {
         System.out.println("Insufficient balance or invalid amount.");
     }
 }

 @Override
 public String toString() {
     return "Account[" + accountNumber + ", " + accountHolderName + ", Balance: ₹" + balance + "]";
 }
}


public class EncapsulationRealTimeExample {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("AS1262", "Suraj jaiswal", 5000.00);
		account.deposit(2000.00);
		account.withdraw(1000.00);
		
		System.out.println(" Account balance : "+account.getBalance());
	}
	
	 
}
