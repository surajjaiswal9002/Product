package com.Target.Product;

import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface calculator{
	
	 String sound(String sound);
}

public class Empower {
	public static void main(String[] args) {
		
		
		calculator c =  s -> s.toUpperCase();
		
		c.sound("Hello");
		
		// list of string -- remove the dublicate and use function interface to upper case ;
		
		List<String> list = Arrays.asList("apple", "banana", "apple");
		
		Set<String> unique = new HashSet<String>();
		
		Set<String> ans = list.stream().distinct().map(c::sound).collect(Collectors.toSet());
		System.out.println(ans);
		
		
		// s
	}
}
