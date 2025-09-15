package com.Target.Product.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class person implements Comparable<person>{
	int age;
	String name;
	
	person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int hashcode() {
		return Objects.hash(age, name);
	}
	
	public boolean equals(Object o) {
		
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		person that = (person) o;
		return that.age == age && Objects.equals(name, that.age);
	}
	
	public String toString() {
		return name + "( "+age+")";
	}
	
	public int compareTo(person p) {
		return Integer.compare(this.getAge(), p.getAge());
	}
}




public class ComprableExample {
	public static void main(String[] args) {
		List<person> list = new ArrayList<>();
		list.add(new person(29, "suraj"));
		list.add(new person(27, "savat"));
		list.add(new person(28, "javat"));
		
		System.out.println(" Before sort "+list);
		
		// sort using comparable (natural order by age )
		Collections.sort(list);
		System.out.println(" After sort "+list);
		
		// comparator
		list.sort(Comparator.comparing(person::getAge).thenComparing(person::getName));
		 System.out.println("After sort by name, then age: " + list);
		//or
		Collections.sort(list, (p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		 System.out.println("After sort by age: " + list);
		
	}
}
