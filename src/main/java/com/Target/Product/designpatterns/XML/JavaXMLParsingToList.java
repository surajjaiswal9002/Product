package com.Target.Product.designpatterns.XML;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 * Simple XML Parsing - Store in List
 * Perfect for Interview
 */
public class JavaXMLParsingToList {
    
    // Employee Class
    static class Employee {
        int id;
        String name;
        int age;
        double salary;
        String department;
        
        public Employee(int id, String name, int age, double salary, String department) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }
        
        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', age=" + age + 
                   ", salary=" + salary + ", department='" + department + "'}";
        }
    }
    
    // Sample XML String
    static final String XML_DATA = 
        "<?xml version=\"1.0\"?>" +
        "<employees>" +
        "  <employee id=\"1\">" +
        "    <n>Alice</n>" +
        "    <age>28</age>" +
        "    <salary>75000</salary>" +
        "    <department>IT</department>" +
        "  </employee>" +
        "  <employee id=\"2\">" +
        "    <n>Bob</n>" +
        "    <age>35</age>" +
        "    <salary>85000</salary>" +
        "    <department>HR</department>" +
        "  </employee>" +
        "  <employee id=\"3\">" +
        "    <n>Charlie</n>" +
        "    <age>30</age>" +
        "    <salary>90000</salary>" +
        "    <department>IT</department>" +
        "  </employee>" +
        "</employees>";
    
    public static void main(String[] args) {
        try {
            // Parse XML and store in List
            List<Employee> employeeList = parseXMLToList();
            
            // Display all employees
            System.out.println("=== ALL EMPLOYEES ===");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
            
            System.out.println("\n=== TOTAL COUNT ===");
            System.out.println("Total Employees: " + employeeList.size());
            
            // Filter employees with salary > 80000
            System.out.println("\n=== HIGH SALARY (>80000) ===");
            for (Employee emp : employeeList) {
                if (emp.salary > 80000) {
                    System.out.println(emp.name + " - ₹" + emp.salary);
                }
            }
            
            // Filter employees in IT department
            System.out.println("\n=== IT DEPARTMENT ===");
            for (Employee emp : employeeList) {
                if ("IT".equals(emp.department)) {
                    System.out.println(emp.name + " (Age: " + emp.age + ")");
                }
            }
            
            // Calculate average salary
            System.out.println("\n=== AVERAGE SALARY ===");
            double totalSalary = 0;
            for (Employee emp : employeeList) {
                totalSalary += emp.salary;
            }
            double avgSalary = totalSalary / employeeList.size();
            System.out.println("Average Salary: ₹" + avgSalary);
            
            // Find highest salary
            System.out.println("\n=== HIGHEST SALARY ===");
            Employee highestPaid = employeeList.get(0);
            for (Employee emp : employeeList) {
                if (emp.salary > highestPaid.salary) {
                    highestPaid = emp;
                }
            }
            System.out.println(highestPaid.name + " - ₹" + highestPaid.salary);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Method to parse XML and return List of Employees
    public static List<Employee> parseXMLToList() throws Exception {
        List<Employee> employees = new ArrayList<>();
        
        // Step 1: Create DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Step 2: Parse XML String
        Document doc = builder.parse(new InputSource(new StringReader(XML_DATA)));
        doc.getDocumentElement().normalize();
        
        // Step 3: Get all employee nodes
        NodeList nodeList = doc.getElementsByTagName("employee");
        
        // Step 4: Loop through each employee and add to List
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                
                // Extract data
                int id = Integer.parseInt(element.getAttribute("id"));
                String name = element.getElementsByTagName("n").item(0).getTextContent();
                int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
                double salary = Double.parseDouble(element.getElementsByTagName("salary").item(0).getTextContent());
                String department = element.getElementsByTagName("department").item(0).getTextContent();
                
                // Create Employee object and add to list
                Employee emp = new Employee(id, name, age, salary, department);
                employees.add(emp);
            }
        }
        
        return employees;
    }
}

/*
OUTPUT:
=== ALL EMPLOYEES ===
Employee{id=1, name='Alice', age=28, salary=75000.0, department='IT'}
Employee{id=2, name='Bob', age=35, salary=85000.0, department='HR'}
Employee{id=3, name='Charlie', age=30, salary=90000.0, department='IT'}

=== TOTAL COUNT ===
Total Employees: 3

=== HIGH SALARY (>80000) ===
Bob - ₹85000.0
Charlie - ₹90000.0

=== IT DEPARTMENT ===
Alice (Age: 28)
Charlie (Age: 30)

=== AVERAGE SALARY ===
Average Salary: ₹83333.33333333333

=== HIGHEST SALARY ===
Charlie - ₹90000.0

KEY INTERVIEW POINTS:

1. PARSING STEPS:
   - Create DocumentBuilderFactory
   - Create DocumentBuilder
   - Parse XML to Document
   - Get NodeList by tag name
   - Loop and convert to objects

2. STORE IN LIST:
   - Create ArrayList<Employee>
   - Loop through NodeList
   - Extract data from each node
   - Create Employee object
   - Add to list using employees.add(emp)

3. COMMON OPERATIONS ON LIST:
   - Size: list.size()
   - Loop: for (Employee emp : list)
   - Filter: if condition inside loop
   - Calculate: sum, average, max, min

4. INTERVIEW VARIATIONS:
   Q: How to read from file?
   A: doc = builder.parse(new File("employees.xml"));
   
   Q: How to handle null values?
   A: Check if nodeList.getLength() > 0 before accessing
   
   Q: Store only names in List<String>?
   A: List<String> names = new ArrayList<>();
      names.add(element.getElementsByTagName("name").item(0).getTextContent());
*/
