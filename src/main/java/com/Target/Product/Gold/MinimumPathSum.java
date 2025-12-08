package com.Target.Product.Gold;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinimumPathSum {
	public static void main(String[] args) {
		int[][] mat = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		
		int minSum = findMinPathSum(mat);
		System.out.println("\n Minumum path sum : "+minSum);
	}
	
	public static int findMinPathSum(int[][] mat) {
		int n = mat.length;
		int m= mat[0].length;
		
		for(int i = 1; i < n; i++) {
			mat[i][0] += mat[i - 1][0];
		}
		
		for(int j = 1; j < m; j++) {
			mat[0][j] += mat[0][j - 1];
		}
		
		
		
		for(int i = 1; i < n; i ++) {
			for(int j = 1; j < m; j++) {
				mat[i][j] = mat[i][j] + Math.min(mat[i - 1][j], mat[i][j - 1]);
			}
		}
		
		Arrays.stream(mat).map(Arrays::toString).forEach(System.out::print);
		return mat[n - 1][m - 1];
	}
}
