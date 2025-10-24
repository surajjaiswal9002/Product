package com.Target.Product.designpatterns.java8;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();

		
        employees.add(new Employee(101, "Alice", 23, "HR", 45000, "Bangalore"));
        employees.add(new Employee(102, "Bob", 25, "IT", 60000, "Bangalore"));
        employees.add(new Employee(103, "Charlie", 30, "Finance", 75000, "Delhi"));
        employees.add(new Employee(104, "David", 28, "IT", 80000, "Mumbai"));
        employees.add(new Employee(105, "Eve", 35, "Finance", 90000, "Delhi"));
        employees.add(new Employee(106, "Frank", 29, "HR", 50000, "Bangalore"));
        employees.add(new Employee(107, "Grace", 40, "IT", 120000, "Mumbai"));

        // Print all employees
       // employees.forEach(System.out::println);
        
        // Filter employees with age >= 25 and salary > 50000, then collect names
        List<String> names = employees.stream()
                .filter(e -> e.age >= 25)
                .filter(e -> e.salary > 50000)
                .filter(e ->e.city.equals("Bangalore"))
                .map(e -> e.name + " - " + e.salary) // name + salary
                .collect(Collectors.toList());
        
        
        System.out.println(" 11 -> "+names);
        
        
        List<Employee> filtered = employees.stream()
                .filter(e -> e.age >= 25)
                .filter(e -> e.salary > 50000)
                .filter(e -> e.city.equals("Bangalore"))
                .collect(Collectors.toList());

       
        System.out.println("Employees " + filtered);
        names.forEach(System.out::println);
        
        
        
        List<String> newList = employees.stream()
        	    .filter(e -> e.age >= 25)
        	    .filter(e -> e.salary > 50000)
        	    .filter(e -> e.city.equals("Bangalore"))
        	    .sorted(
        	        Comparator.comparing((Employee e) -> e.city)
        	                  .thenComparing(e -> e.salary)
        	                  .reversed() // reverse overall order
        	    )
        	    .map(e -> e.name + " - " + e.salary)
        	    .collect(Collectors.toList());
        
        System.out.println("newList - >"+newList);

	}
}
