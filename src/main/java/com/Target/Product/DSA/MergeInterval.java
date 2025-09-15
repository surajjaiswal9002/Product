 package com.Target.Product.DSA;

import java.util.*;

public class MergeInterval {
	public static void main(String[] args) {

		int[][] intervals = { { 15, 18 }, { 1, 3 }, { 2, 6 }, { 8, 10 } };

		int[][] res = merge(intervals);
		
		for(int[] interval : res) {
			System.out.println(" "+Arrays.toString(interval));
		}
	}
	
	
	
	// O(n .log n) and sc - O(n)
	public static int[][] merge(int[][] intervals){
		int n = intervals.length;
		
		// sort
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> res = new ArrayList<int[]>();
		res.add(new int[] {intervals[0][0], intervals[0][1]});
		
		for(int i = 1; i < n; i++) {
			int[] curr = intervals[i];
			int[] last = res.get(res.size() - 1);
			
			if(curr[0] <= last[1]) {
				last[1] = Math.max(last[1], curr[1]);
			}else {
				res.add(new int[] {curr[0], curr[1]});
			}
		}
		
		return res.toArray(new int[res.size()][]);
	}

}
