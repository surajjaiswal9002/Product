package com.Target.Product.designpatterns.java8;

import java.util.*;
import java.util.stream.*;

class Employeeeee {
    private String name;
    private long salary;

    public Employeeeee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
    public long getSalary() { return salary; }
    public String getName() { return name; }
}

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Employeeeee> employees = Arrays.asList(
            new Employeeeee("Aditi", 100000),
            new Employeeeee("Rahul", 130000),
            new Employeeeee("Vishal", 110000),
            new Employeeeee("Lakshmi", 150000),
            new Employeeeee("Priya", 90000),
            new Employeeeee("Rohit", 150000)
        );

        Optional<Long> secondHighestSalary = employees.stream()
            .map(Employeeeee::getSalary)           // Extract salaries
            .distinct()                        // Remove duplicates
            .sorted(Comparator.reverseOrder()) // Sort descending
            .skip(1)                          // Skip highest
            .findFirst();                     // Get second highest if exists

        if (secondHighestSalary.isPresent()) {
            System.out.println("Second highest salary is: " + secondHighestSalary.get());
        } else {
            System.out.println("There is no second highest salary");
        }
    }
}

