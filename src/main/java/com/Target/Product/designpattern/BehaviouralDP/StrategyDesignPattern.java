package com.Target.Product.designpattern.BehaviouralDP;


// strategy DP is a behavioral DP that let you define a family of algorithms, 
//put each of them into a seprate class and make it object interchange at runtime;


// strategy
interface PaymentStrategy{
	public void pay(int amount);
}

// concrete strategy
class CreditcardPayment implements PaymentStrategy{
	private long creditcardNumber;
	
	public CreditcardPayment(long creditcardNumber){
		this.creditcardNumber = creditcardNumber;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(" Pay : "+amount+" using creditcard "+creditcardNumber);
	}
}


class Paypalpayment implements PaymentStrategy{
	private String email;
	
	public Paypalpayment(String email) {
		this.email = email;
	}
	
	public void pay(int amount) {
		System.out.println(" Pay : "+amount+" using paypal "+email);
	}
}



//context
class PaymentServices{
	private PaymentStrategy paymentStrategy;
	
	public PaymentServices( PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void processOrder(int amount) {
		paymentStrategy.pay(amount);
	}
}

public class StrategyDesignPattern {
	public static void main(String[] args) {
		
		PaymentServices ccPayment = new PaymentServices(new CreditcardPayment(111111111111111L));
		ccPayment.processOrder(500);
		
		PaymentServices paypalPayment = new PaymentServices(new Paypalpayment("surajjaiswal@gmail.com"));
		paypalPayment.processOrder(400);
	}
}
