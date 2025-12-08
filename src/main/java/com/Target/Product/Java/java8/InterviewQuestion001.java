package com.Target.Product.Java.java8;
import java.util.*;
import java.util.stream.Collectors;
//Given an Employee class with id, name, age, salary and dept. Pull out all employees
//with sal&gt;50000 and dept=Accounts. Sort the result in desc order and store the result in a
//set.
public class InterviewQuestion001 {
	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList(new Employee(1, "Suraj", 27, "DE", 50000, "Banglore"),
				
				new Employee(2, "Rishabh", 28, "Account", 5000, "Jharsuguda"),
				new Employee(3, "Shyam", 30, "SAP", 4000, "banglore"),
				new Employee(4, "Chinmay", 32, "Account", 45000, "BBSR")
				
				);
		
		Set<Employee> data = list.stream()
				.filter(n -> n.getSalary() >= 5000 && n.getDepartment().equals("Account"))
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toCollection(HashSet::new));

		System.out.println(data);
		
		
		int[] arr = {1, 2, 3, 4, 1, 2, 4, 6, 9, 3, 0, 7};
		
		int[] ans = Arrays.stream(arr)
							.distinct().boxed()
							.sorted().collect(Collectors.toSet()).stream().mapToInt(Integer::intValue).toArray();
		
		int[] anss = Arrays.stream(arr)
				.distinct().boxed()
				.sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();


		
		System.out.println(Arrays.toString(anss
				));
		
	}
}
