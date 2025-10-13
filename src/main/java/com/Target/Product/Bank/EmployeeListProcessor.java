package com.Target.Product.Bank;


import java.util.*;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;
 
public class EmployeeListProcessor {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Alice"));

        employeeList.add(new Employee(2, "Bob"));

        employeeList.add(new Employee(1, "Alice")); // Duplicate

        employeeList.add(new Employee(3, "Charlie"));

        employeeList.add(new Employee(2, "Bob"));   // Duplicate
 
        
        
        
       Set<Employee> set = new HashSet<Employee>();
       Set<Employee> dublicateSet = new HashSet<Employee>();
       int n = employeeList.size();
       
       
       for(int i = 0; i < n; i++) {
    	   
    	   if(!set.add(employeeList.get(i))) {
    		   dublicateSet.add(employeeList.get(i));
    	   }
       }
       
       System.out.println(dublicateSet);
       
        
    }

}
 