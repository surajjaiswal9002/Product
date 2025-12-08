package com.Target.Product.Java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("Hello Suraj");
		
		
		List<Employee> employee = Arrays.asList(new Employee(001, "Suraj", 27, "DE", 50000000.00, "Banglore"),
				new Employee(002, "Ashok", 28, "DE", 800000.00, "Banglore"));
		
		Consumer<Employee> printEmployee = emp -> System.out.print(" Name = "+emp.getName()+", Age - "+emp.getAge()+"\n");
		employee.forEach(printEmployee);
	}
}	
