package com.Target.Product.Java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee001{
	private int id;
	private String name;
	private int deptId;
	private int commitCount;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getCommitCount() {
		return commitCount;
	}

	public void setCommitCount(int commitCount) {
		this.commitCount = commitCount;
	}

	public Employee001(int id, String name, int deptId, int commitCount) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.commitCount = commitCount;
	}

	@Override
	public String toString() {
		return "Employee001 [id=" + id + ", name=" + name + ", deptId=" + deptId + ", commitCount=" + commitCount + "] \n ";
	}
}


public class MaxCommitPerDept {
	public static void main(String[] args) {
		
		List<Employee001> list = Arrays.asList(
				new Employee001(1, "Alice", 101, 50),
				new Employee001(2, "Bob", 102, 30), 
				new Employee001(3, "Charlie", 101, 75), 
				new Employee001(4, "David", 103, 20), 
				new Employee001(5, "Eva", 103, 45), 
				new Employee001(6, "Frank", 101, 60));
		
		
		Map<Integer, Employee001> topCommiter = 
				list.stream()
					.collect(Collectors.groupingBy(Employee001::getDeptId, 
							Collectors.collectingAndThen(Collectors.maxBy(
									Comparator.comparingInt(Employee001::getCommitCount)), Optional::get)));
		
		System.out.println(topCommiter);
	}
}
