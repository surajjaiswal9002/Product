package com.Target.Product.Java;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee003{
	String name;
	int id;
	
	
	Employee003(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String toString() {
		return "Employee003+[ : id +"+id+", name : "+name+"]";
	}


	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Employee003 that = (Employee003) obj;
		return id == that.id && Objects.equals(name, that.name);
	}
	
	
}


public class SetExample {
	public static void main(String[] args) {
		
		
		Set<Employee003> set = new HashSet<Employee003>();
		
		Employee003 e1 = new Employee003("Suraj", 10001);
		Employee003 e2 = new Employee003("Suraj", 10001);
		
		set.add(e1);
		set.add(e2);
		System.out.println(set);
		
	}
}
