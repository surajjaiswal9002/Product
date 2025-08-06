package com.Target.Product.Java;

import java.util.Objects;

class Student {
	// Data hiding
	private int regNum;
	private String name;
	private int age;

	// getter
	public int getRegName() {
		return regNum;
	}

	// setter
	public void setRegName(int regNum) {
		this.regNum = regNum;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	// getter
	public String getName() {
		return name;
	}

	// setter
	public void setAge(int age) {
		this.age = age;
	}

	// getter
	public int getAge() {
		return age;
	}

	
	// construncto
	Student(int regNum, String name, int age){
		this.regNum = regNum;
		this.name = name;
		this.age = age;
	}
	
	
	// toString
	public String toString() {
		return "Student - [ regNum : "+regNum+", name : "+name+", age : "+age+" ]";
	}
	
	
	// hashcode
	public int hashcode() {
		return Objects.hash(regNum, name, age);
	}
	
	
	// equals method
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Student s = (Student) obj;
		
		return s.regNum == regNum && Objects.equals(s.name, name) && s.age == age;
}
	
}

public class EncapsulationExample {
	public static void main(String[] args) {

		Student s = new Student(0, null, 0);
		s.setRegName(001);
		s.setName("Suraj jaiswal");
		s.setAge(27);

		System.out.println("RegNum - " + s.getRegName() + ", Name - " + s.getName() + ", Age - " + s.getAge());
		System.out.println(s);  // toString(
	}
}
