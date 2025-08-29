package com.Target.Product.designpatterns.java8;

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

    @Override
    public String toString() {
        return id + " - " + name + " (" + age + " yrs, " + department + ", " + salary + ", " + city + ")";
    }
}

