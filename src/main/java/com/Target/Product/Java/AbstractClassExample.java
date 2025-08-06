package com.Target.Product.Java;

abstract class ATM{
	
	// Abstract method(no body)
	public abstract void withdraw(double amount);
	
	
	// concrete method(has body)
	public void checkBalance(double balance) {
		System.out.println(" Available Balance : "+balance);
	}
}



class SBIAtm extends ATM{

	private double balance;
	
	public SBIAtm(double balance){
		this.balance = balance;
	}
	
	@Override
	public void withdraw(double amount) {
		
		if(amount <=  balance) {
			balance -=amount;
			System.out.println(" Withdrawn : "+amount);
			checkBalance(balance);
		}else {
			System.out.println(" Insufficent fund ** ");
		}
	}
	
}

public class AbstractClassExample {

	public static void main(String[] args) {
		
		ATM atm = new SBIAtm(5000.00);
		
		atm.withdraw(100.00);
		
	}
}
