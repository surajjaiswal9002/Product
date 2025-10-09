package com.Target.Product.designpattern.StructuralDP;


// composite DP, is a structural DP WORKING LIKE A TREE STRUCTURE, LIKE FOLDER HAS FILE OR FOLDER AND AGAIN FOLDER HAS FILE AND FOLDER
//Example 2 - Electronic --> mobile --> Lg, Samsung, Apple, Xiome
//							---> Tv -> Samsung, LG, ..
import java.util.*;

//Component
interface CatalogComponent {
 void showDetails();
}

//Leaf
class Product implements CatalogComponent {
 private String name;
 Product(String name) { this.name = name; }
 public void showDetails() { System.out.println("Product: " + name); }
}

//Composite
class Category implements CatalogComponent {
 private String name;
 private List<CatalogComponent> components = new ArrayList<>();
 Category(String name) { this.name = name; }
 public void add(CatalogComponent c) { components.add(c); }
 public void showDetails() {
     System.out.println("Category: " + name);
     for (CatalogComponent c : components) c.showDetails();
 }
}

//Usage
public class CompositePattern {
 public static void main(String[] args) {
     Product iphone = new Product("iPhone");
     Product galaxy = new Product("Samsung Galaxy");
     
     Category mobiles = new Category("Mobiles");
     mobiles.add(iphone);
     mobiles.add(galaxy);
     
     Category electronics = new Category("Electronics");
     electronics.add(mobiles);
     
     electronics.showDetails();
 }
}

