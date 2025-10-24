package com.Target.Product.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorCustomSorting {
	public static void main(String[] args) {
List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(001, "Bob"));
		list.add(new Employee(002, "Aob"));
		list.add(new Employee(003, "Cob"));
		
		//Collections.sort(list);
		
		System.out.println(list);
		
		list.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getId));
		System.out.println(list);
	}
}
