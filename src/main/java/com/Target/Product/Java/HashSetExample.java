package com.Target.Product.Java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetExample {
	public static void main(String[] args) {
	
		   Set<Integer> s= new HashSet<>(); 
		   s.add(1);
		   s.add(8);
		   s.add(1);
		   s.add(11);
		   s.add(10);
		   s.add(101);
		   s.add(10);
		   s.add(102);
		   System.out.println(s.toString());  
		  // Filter the data value >10 
		  System.out.println( s.parallelStream()
		    .filter(value->value >10 )
		   .collect(Collectors.toSet()));
		
	}
}
