package com.Target.Product.designpattern.StructuralDP;



// Adaptor Design pattern is a structural design pattern, where creating bridge between 2 incompatable interface 
//without modifying their existing code.


//Step 1: Target Interface — Walmart’s expected format
interface PaymentProcessor {
 void makePayment(double amount);
}

//Step 2: Adaptee — Third-party payment service (incompatible interface)
class PayFastAPI {
 public void sendPayment(double money, String currency) {
     System.out.println("Processing payment of " + money + " " + currency + " via PayFast.");
 }
}

//Step 3: Adapter — bridges the two
class PayFastAdapter implements PaymentProcessor {
 private PayFastAPI payFastAPI;

 public PayFastAdapter(PayFastAPI payFastAPI) {
     this.payFastAPI = payFastAPI;
 }

 @Override
 public void makePayment(double amount) {
     // Adapter converts Walmart’s expected method to PayFast’s method
     payFastAPI.sendPayment(amount, "USD");
 }
}

//Step 4: Client — Walmart checkout system
class WalmartCheckout {
 private PaymentProcessor paymentProcessor;

 public WalmartCheckout(PaymentProcessor paymentProcessor) {
     this.paymentProcessor = paymentProcessor;
 }

 public void completeOrder(double amount) {
     System.out.println("Order total: $" + amount);
     paymentProcessor.makePayment(amount);
 }
}

//Step 5: Test
public class AdaptorDp {
 public static void main(String[] args) {
     PayFastAPI payFastAPI = new PayFastAPI();
     PaymentProcessor adapter = new PayFastAdapter(payFastAPI);

     WalmartCheckout checkout = new WalmartCheckout(adapter);
     checkout.completeOrder(150.75);
 }
}

