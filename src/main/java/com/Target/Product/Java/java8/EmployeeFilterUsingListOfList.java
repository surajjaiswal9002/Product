package com.Target.Product.Java.java8;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeFilterUsingListOfList {
	public static void main(String[] args) {
		List<List<Employee>> list = Arrays.asList(
				Arrays.asList(new Employee(001, "Kiran", 45, "BE", 100.00, "Banglore"),
						new Employee(002, "Sameer", 21, "FM", 200.00, "Andra"),
						new Employee(003, "Samyak", 25, "GS", 400.00, "HSR"),
						new Employee(004, "Vishal", 21, "PS", 300.00, "Hydrabad")));
		
		
		List<String> salaryInString =  list.stream()
				.flatMap(List::stream)
				.filter(e -> e.getSalary() <= 300 && e.getAge() == 21)
				.map(e -> String.valueOf(e.getSalary())+", "+e.getName()).
				collect(Collectors.toList());
		
		
		System.out.println(" Salary In String : "+salaryInString);
				
				
				
//				// Extract salaries as List<String> using for loop
//		        List<String> salariesAsStringLoop = new ArrayList<>();
//		        for (List<Employee> dept : departments) {
//		            for (Employee e : dept) {
//		                if (e.getAge() > 20 && e.getSalary() == 100) {
//		                    salariesAsStringLoop.add(String.valueOf(e.getSalary()));
//		                }
//		            }
//		        }
	}
}
