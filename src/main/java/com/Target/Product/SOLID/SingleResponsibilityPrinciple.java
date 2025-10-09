package com.Target.Product.SOLID;


// A class should have only one reason to change, i.e., it should have only one responsibility or purpose.

//1. Domain Class (Marker) – only holds data
class Marker {
 String name;
 String color;
 int quantity;

 public Marker(String name, String color, int quantity) {
     this.name = name;
     this.color = color;
     this.quantity = quantity;
 }
}

//2. Invoice Service – handles invoice generation
class InvoiceService {
 void createInvoice(Marker marker) {
     System.out.println("Creating invoice for " + marker.name);
 }
}

//3. Database Service – handles DB operations
class DatabaseService {
 void save(Marker marker) {
     System.out.println("Saving " + marker.name + " to database");
 }
}

//4. Print Service – handles printing
class PrintService {
 void print(Marker marker) {
     System.out.println("Printing details: " + marker.name + ", " + marker.color);
 }
}

public class SingleResponsibilityPrinciple {
	public static void main(String[] args) {
        Marker marker = new Marker("SketchPen", "Red", 100);
        
        InvoiceService invoiceService = new InvoiceService();
        DatabaseService dbService = new DatabaseService();
        PrintService printService = new PrintService();
        
        invoiceService.createInvoice(marker);
        dbService.save(marker);
        printService.print(marker);
    }
}
