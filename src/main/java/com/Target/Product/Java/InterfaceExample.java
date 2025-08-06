package com.Target.Product.Java;

//  A common contract all apps must follow (send money, receive money)
//  Interface – Pure Specification (no implementation)
interface UpiPayment {
    void sendMoney(String toUpiId, double amount);
    void receiveMoney(String fromUpiId, double amount);
}



// Abstract Class – Partial Implementation (some logic reused)
abstract class AbstractUpiApp implements UpiPayment {

    // shared validation logic
    protected boolean validateUpiId(String upiId) {
        return upiId != null && upiId.contains("@");
    }

    // shared logging logic
    protected void logTransaction(String action, double amount) {
        System.out.println("[" + action + "] Amount: ₹" + amount);
    }
}


class Fedmobile extends AbstractUpiApp {

    @Override
    public void sendMoney(String toUpiId, double amount) {
        if (validateUpiId(toUpiId)) {
            System.out.println("PhonePe: Sending ₹" + amount + " to " + toUpiId);
            logTransaction("Send", amount);
        } else {
            System.out.println("Invalid UPI ID");
        }
    }

    @Override
    public void receiveMoney(String fromUpiId, double amount) {
        if (validateUpiId(fromUpiId)) {
            System.out.println("PhonePe: Received ₹" + amount + " from " + fromUpiId);
            logTransaction("Receive", amount);
        } else {
            System.out.println("Invalid UPI ID");
        }
    }
}


public class InterfaceExample {
	    public static void main(String[] args) {
	        UpiPayment app = new Fedmobile();

	        app.sendMoney("rahul@okicici", 500.00);
	        app.receiveMoney("priya@oksbi", 200.00);
	    }


}
