package com.Target.Product;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interview0000003 {
		
	
		// Email pattern "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
	 
		// Phone pattern "^(\\+91[-\\s]?)?[6-9]\\d{9}$"
	
	 public static void main(String[] args) {
		 
		 
		 String email = "suraj@gmail.com";
		 String mob = "+918457809598";
		 EmailValidation(email);
		 //PhoneNumValidation(mob);
	}
	 
	 public static void EmailValidation(String email) {
		 if(email == null || email.length() <= 0) {
			 System.out.println("Email Id Should be present");
		 }
		 
		//String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}$";
		 String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		Pattern pattern =  Pattern.compile(regex);
		 Matcher match = pattern.matcher(email);
		 
		 if(match.matches()) {
			 System.out.println(" Email verified");
			 
		 }else {
			 System.out.println(" Not Varified ");
		 }
	 }
	 
	 
	 ///Employee(emp_id, emp_name, salary, dept_id)
//Department(dept_id, dept_name, location)
//Project(proj_id, proj_name, client_name)
//Employee_Project(emp_id, proj_id, hours_worked)
	 
	 
	 //Retrieve department-wise highest salary
//	 Select d1.Dept_nam, e1.salary, e1.name 
//	 from Employee e1 join Dept d1
//	 on e1.dept_id = d.dept_id
//	where e1.salary = (
//			select Max(e2.Salary) from employee e2 
//			where e2.dept_id != e1.dept_id)
//				
//			)
//	
//	 
	
	 
	 
	 
	 
	 
}
