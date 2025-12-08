package com.Target.Product.Java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employeeee {
    private String name;
    private String department;
    private double salary;
    private int age;
    
    public Employeeee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }
    
    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary;
    }
}

public class RealWorldStreamExample {
    public static void main(String[] args) {
        List<Employeeee> employees = Arrays.asList(
            new Employeeee("John", "IT", 50000, 30),
            new Employeeee("Jane", "HR", 45000, 28),
            new Employeeee("Jack", "IT", 60000, 35),
            new Employeeee("Jill", "Finance", 55000, 32),
            new Employeeee("James", "IT", 52000, 29),
            new Employeeee("Jenny", "HR", 48000, 26),
            new Employeeee("Joe", "Finance", 58000, 34)
        );
        
        System.out.println("=== Stream API Processing Examples ===\n");
        
        // 1. Find all IT employees with salary > 50000
        System.out.println("1. IT employees with salary > 50000:");
        employees.stream()
            .filter(e -> e.getDepartment().equals("IT"))
            .filter(e -> e.getSalary() > 50000)
            .forEach(System.out::println);
        
        
        // 2. Get list of employee names in HR department
        System.out.println("\n2. HR employee names:");
        List<String> hrNames = employees.stream()
            .filter(e -> e.getDepartment().equals("HR"))
            .map(Employeeee::getName)
            .collect(Collectors.toList());
        System.out.println(" Name : "+hrNames);
        
        
        // 3. Calculate average salary by department
        System.out.println("\n3. Average salary by department:");
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
            	Employeeee::getDepartment,
                Collectors.averagingDouble(Employeeee::getSalary)
            ));
        avgSalaryByDept.forEach((dept, avg) -> 
            System.out.println(dept + ": $" + avg));
        
        
        // 4. Find highest paid employee
        System.out.println("\n4. Highest paid employee:");
        Employeeee highestPaid = employees.stream()
            .max(Comparator.comparing(Employeeee::getSalary))
            .orElse(null);
        System.out.println(highestPaid);
        
        
        // 5. Count employees by department
        System.out.println("\n5. Employee count by department:");
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(
            	Employeeee::getDepartment,
                Collectors.counting()
            ));
        countByDept.forEach((dept, count) -> 
            System.out.println(dept + ": " + count));
        
        
        // 6. Get top 3 highest salaries
        System.out.println("\n6. Top 3 salaries:");
        employees.stream()
            .map(Employeeee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .forEach(System.out::println);
        
        
        // 7. Check if any employee age > 35
        System.out.println("\n7. Any employee > 35 years?");
        boolean anyOld = employees.stream()
            .anyMatch(e -> e.getAge() > 35);
        System.out.println(anyOld);
        
        
        // 8. Total salary expenditure
        System.out.println("\n8. Total salary expenditure:");
        double totalSalary = employees.stream()
            .mapToDouble(Employeeee::getSalary)
            .sum();
        System.out.println("$" + totalSalary);
        
        
        // 9. Partition employees: salary >= 50000 or < 50000
        System.out.println("\n9. Partition by salary >= 50000:");
        Map<Boolean, List<Employeeee>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.getSalary() >= 50000));
        System.out.println("High earners: " + partitioned.get(true).size());
        System.out.println("Others: " + partitioned.get(false).size());
        
        
        // 10. Get departments with more than 2 employees
        System.out.println("\n10. Departments with > 2 employees:");
        countByDept.entrySet().stream()
            .filter(entry -> entry.getValue() > 2)
            .map(Map.Entry::getKey)
            .forEach(System.out::println);
    }
}
