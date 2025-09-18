package com.Target.Product.designpatterns.java8;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Person12 {
    String name;
    int age;
    Person12(String name, int age) { this.name = name; this.age = age; }
    
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}



public class StreamExample {
	public static void main(String[] args) {
		
		
		// Arrays.asList(mutable);
		List<Integer> list = Arrays.asList(54, 34, 36, 76, 12, 21, 32, 90);
		
		List<Integer> res = list.stream().map(n -> n+2).filter(n -> n % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(" list "+res);
		
		
		List<String> names = Arrays.asList("Suraj", "Amit", "Ravi");
		List<String> nameStartwith = names.stream().filter(n -> n.startsWith("S")).toList();
		
		System.out.println(nameStartwith);
		
		
		// reduced 
		// List.of - immutable 
		List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);  
		
		int sum = numList.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
		//Parallel streams can improve performance for large datasets.
		int sum2 = numList.parallelStream().reduce(0, Integer::sum);
		System.out.println(sum2);
		
		
		List<Person12> people = Arrays.asList(
			    new Person12("Suraj", 27),
			    new Person12("Amit", 27),
			    new Person12("Ravi", 30)
			);

			Map<Integer, List<Person12>> groupedByAge = people.stream().collect(Collectors.groupingBy(p -> p.age));

			System.out.println(groupedByAge);
			
			
			int max = numList.stream().max(Integer::compareTo).orElseThrow();
			int min = numList.stream().min(Integer::compareTo).orElseThrow();

			System.out.println("Max: " + max); // 8
			System.out.println("Min: " + min); // 1
			
			int sumOfSquares = numList.stream()
			        .map(n -> n * n)              // square each number
			        .reduce(0, Integer::sum);     // sum all squares

			System.out.println(sumOfSquares); // 5^2+2^2+8^2+1^2+4^2+6^2 = 130

	}
}
