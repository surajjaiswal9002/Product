package com.Target.Product.designpattern.BehaviouralDP;


// Observer dp is a behavioral design pattern, to notify all the object, any event happen for that particular object
import java.util.*;

//Publisher
class Product {
 private String name;
 private double price;
 
 Product(String name, double price) {
     this.name = name;
     this.price = price;
 }
 
 public synchronized void setPrice(double price) {
     this.price = price;
     notifyAll(); // notify all waiting subscribers
 }
 
 public synchronized void waitForUpdate(String userName) throws InterruptedException {
     wait(); // wait until price changes
     System.out.println(userName + " notified: " + name + " new price $" + price);
 }
}

//Demo
public class ObserverPattern {
 public static void main(String[] args) {
     Product iphone = new Product("iPhone", 999);
     
     // Subscriber 1
     new Thread(() -> {
         try { iphone.waitForUpdate("Alice"); }
         catch (InterruptedException e) {}
     }).start();
     
     // Subscriber 2
     new Thread(() -> {
         try { iphone.waitForUpdate("Bob"); }
         catch (InterruptedException e) {}
     }).start();
     
     // Publisher updates price
     try {
         Thread.sleep(1000);
         iphone.setPrice(899);
         Thread.sleep(1000);
         iphone.setPrice(799);
     } catch (InterruptedException e) {}
 }
}



