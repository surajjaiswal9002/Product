package com.Target.Product;

import java.util.*;
import java.util.stream.Collector;


public class Test009 {
	public static void main(String[] args) {
//		List of fruits
//
		List<String> fruits= Arrays.asList(new String[]{"Chikoo", "Mango", "Banana", "Mango", "Banana", "Mango","Papaya"}); 
//
		
//		Write a java code to return Fruits in descending order of their count.
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Physic", 87);
		map.put("chem", 85);
		map.put("math", 87);
		
		for(String s : fruits){
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		System.out.println(map);
		List<Map.Entry<String, Integer>> listOfMap = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		listOfMap.sort((a, b) -> b.getValue().compareTo(a.getValue()));
		
		System.out.println(listOfMap);
		
		//fruits.stream().filter(n -> n.startWith("M")).collect(Collector.toLiust);
		
	}
}
