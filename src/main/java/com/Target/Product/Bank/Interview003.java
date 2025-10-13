package com.Target.Product.Bank;

import java.sql.Array;
import java.util.*;

public class Interview003 {
	public static void main(String[] args) {
		
		String[] str = {"payZapp","Venmo","phonePe","gpay","Amx","zo","a","","payZapp"};
		
		//first occurenece of every string from list have size more than 2 and no duplicates /nulls allowed in final list
		 
//		*character
//		 
//		{"p","V","g",A]
		 
		// condition
		List<Character> res = Arrays.stream(str).filter(n -> n.length() >= 2).map(n -> n.charAt(0)).distinct().toList();
		
		System.out.println(res);
		
		
		
		
		
		
	}
}
