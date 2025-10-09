package com.Target.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interview001 {
    public static void main(String[] args) {
		
    	String s = null;
	
    	
    	String result = mostFrequentsWords(s);
    	System.out.println(" Most frequents words : "+result);
    	
    	
    //	String mostFreqWordStream = mostFrequentsWordsStreams(s);
    	
    
    }
    
    
    public static String mostFrequentsWords(String s) {
    	if(s == null || s.isEmpty() ) {
    		return "Not found";
    	}
    	
    	String[] newString = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\W");
    	
    	// check
    	if(s.isEmpty() || newString.length == 0) {
    		return "Not found";
    	}
    
    	System.out.println(Arrays.toString(newString));
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(String str : newString) {
    		map.put(str, map.getOrDefault(str, 0) + 1);
    	}
    	
    	System.out.println(map);
    	int max = Integer.MIN_VALUE;
    	String res = "";
    	
    	
    	for(Map.Entry<String, Integer> entry : map.entrySet()) {
    		if(entry.getValue() > max) {
    			max = entry.getValue();
    			res = entry.getKey();
    		}
    	}
    	
    	
    	String result = res+","+max;
    	return result;
    }
}
