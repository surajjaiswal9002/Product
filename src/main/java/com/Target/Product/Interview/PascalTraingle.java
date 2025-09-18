package com.Target.Product.Interview;

import java.util.*;

public class PascalTraingle {
	public static void main(String[] args) {
		int row = 6;
		
		List<List<Integer>> resPascalTrangle = genratePascalTraingle(row);
		
		for(List<Integer> res : resPascalTrangle) {
			for(Integer num : res) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> genratePascalTraingle(int row) {
		List<List<Integer>> trangle = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < row; i++) {
			List<Integer> rList = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					rList.add(1);
				}else {
					rList.add(trangle.get(i - 1).get(j - 1) + trangle.get(i - 1).get(j));
				}
			}
			
			trangle.add(rList);
		}
		return trangle;
	}
}
