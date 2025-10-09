package com.Target.Product.SOLID;

//A class should be open for extension but closed for modification.
//Open for extension: You should be able to add new functionality.

//Closed for modification: You should not modify existing code that is already tested and working.


//Discount Strategy Interface
interface Discount {
 double apply(double price);
}

//Concrete Strategies
class NewUserDiscount implements Discount {
 public double apply(double price) { return price * 0.1; }
}

class BlackFridayDiscount implements Discount {
 public double apply(double price) { return price * 0.2; }
}

//Context
class DiscountService {
 public double calculateDiscount(Discount discount, double price) {
     return discount.apply(price);
 }
}

public class OpenClosePrinciple {
	public static void main(String[] args) {
        DiscountService service = new DiscountService();
        Discount discount = new BlackFridayDiscount();
        System.out.println("Discounted Price: " + service.calculateDiscount(discount, 1000));
        
        discount = new NewUserDiscount();
        System.out.println("Discounted Price: " + service.calculateDiscount(discount, 1000));
    }
}
