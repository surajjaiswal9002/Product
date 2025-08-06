package com.Target.Product.Java;

final class Bank{
	
	final String  bankName = "SBI";
	
	final void showDetails() {
		System.out.println(" Bank Name : "+bankName);
	}
}

//Uncommenting below will give compile error because Bank is final
//class MyBank extends Bank {}  ❌ ERROR


public class FinalExample{

	public static void main(String[] args) {
		Bank b = new Bank();
		b.showDetails();
	//	b.bankName = "HDFC";   // compilation error
	}
	
}
