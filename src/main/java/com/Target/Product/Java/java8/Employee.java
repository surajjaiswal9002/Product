package com.Target.Product.Java.java8;

public class Employee {
    int id;
    String name;
    int age;
    String department;
    double salary;
    String city;

    Employee(int id, String name, int age, String department, double salary, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.city = city;
    }

    
    
    
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




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getDepartment() {
		return department;
	}




	public void setDepartment(String department) {
		this.department = department;
	}




	public double getSalary() {
		return salary;
	}




	public void setSalary(double salary) {
		this.salary = salary;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	@Override
    public String toString() {
        return id + " - " + name + " (" + age + " yrs, " + department + ", " + salary + ", " + city + ")";
    }
}

