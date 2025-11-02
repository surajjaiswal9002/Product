package com.Target.Product.JJava11;

import java.util.*;

public class VarExample {
    public static void main(String[] args) {
        
        // Compiler infers types automatically
        var name = "Suraj";            // String
        var age = 27;                  // int
        var salary = 50000.50;         // double
        var isActive = true;           // boolean

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Active: " + isActive);
        
        // Example with a list
        var list = List.of("Java", "Spring", "Microservices");
        for (var item : list) {
            System.out.println(item);
        }
    }
}

