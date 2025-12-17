package com.Target.Product.DSA;

import java.util.*;
import java.util.Map.Entry;

public class HigestAvgMark {
	public static void main(String[] args) {
		String[][] arr = {
                {"Alice", "92"},
                {"Alice", "85"},
                {"Bob", "76"},
                {"Alice", "89"},
                {"Bob", "80"}
        };

		
		System.out.println(higestAvgMark(arr));
	}
	
	public static int higestAvgMark(String[][] arr) {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		
		for(String[] str: arr) {
			String name = str[0];
			int mark = Integer.parseInt(str[1]);
			
			map.putIfAbsent(name, new ArrayList<Integer>());
			map.get(name).add(mark);
		}
		
		
		int higestAvgMark = 0;
		for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			int sum = 0;
			
			for(int n : list) {
				sum +=n;
			}
			
			int avg = sum / list.size();
			
			if(avg > higestAvgMark) {
				higestAvgMark = avg;
			}
		}
		return higestAvgMark;
	}
}
