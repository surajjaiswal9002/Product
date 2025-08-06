package com.Target.Product.Java;

// *** PUBLIC ** 
//Accessible from anywhere

// Can be used by any class in any package
// Public access specifier
class Account {
	public void login() {
		System.out.println("Logged in");
	}
}

// ** PRIVATE **

// Accessible only within the same class
// Cannot be inherited or overridden
class Bankk {
	private double balance;

	private void showBalance() {
		System.out.println("Balance: " + balance);
	}
}

// ** PROTECTED **
//Accessible within the same package and in subclasses (outside the package) via inheritance
//Can be overridden by protected or public
class BankAccounts {
	protected double balance = 1000;
}

class SavingsAccount extends BankAccounts {

	void display() {
		System.out.println("Balance: " + balance); // ✅ Accessible
	}
}

// ** DEFAULT **
//If no modifier is specified, it's default
//Accessible only within the same package
class LoanService {
	void approveLoan() {
		System.out.println("Loan Approved");
	}
}

public class PublicExampleAS {
	public static void main(String[] args) {

		Account ac = new Account();
		ac.login();

		Bankk b = new Bankk();
		// b.showBalance() /// not able to access outside the class
	}
}
