package com.Target.Product.designpattern.StructuralDP;

// Decorator Design Pattern is a structural Design Pattrern, where dynamically add new feature/ responsibility 
//to object without modifing the code  



interface Order {
    double getCost();
    String getDescription();
}

class BasicOrder implements Order {
    public double getCost() { return 100; }
    public String getDescription() { return "Basic Order"; }
}

// Decorator
class OrderDecorator implements Order {
    protected Order order;
    public OrderDecorator(Order order) { this.order = order; }
    public double getCost() { return order.getCost(); }
    public String getDescription() { return order.getDescription(); }
}

// Add-on: Gift wrap
class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(Order order) { super(order); }
    public double getCost() { return super.getCost() + 20; }
    public String getDescription() { return super.getDescription() + ", Gift Wrapped"; }
}

// Add-on: Express Delivery
class ExpressDeliveryDecorator extends OrderDecorator {
    public ExpressDeliveryDecorator(Order order) { super(order); }
    public double getCost() { return super.getCost() + 50; }
    public String getDescription() { return super.getDescription() + ", Express Delivery"; }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Order order = new BasicOrder();
        order = new GiftWrapDecorator(order);
        order = new ExpressDeliveryDecorator(order);
        System.out.println(order.getDescription() + " | Total: $" + order.getCost());
    }
}

