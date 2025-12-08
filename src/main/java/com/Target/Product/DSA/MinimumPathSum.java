package com.Target.Product.DSA;

import java.util.Arrays;

public class MinimumPathSum {
	public static void main(String[] args) {
		
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		
		Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
		System.out.println();
		int ans = findMinPathSum(grid);
		System.out.println(" ans : "+ans);
	}
	
	public static int findMinPathSum(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		
		for(int i = 1; i < n; i++) {
			grid[i][0] = grid[i][0] + grid[i - 1][0];
		}
		
		Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
		
		System.out.println(" 111 ");
		for(int j = 1; j < m; j++) {
			grid[0][j] = grid[0][j] + grid[0][j - 1];
		}
		
		System.out.println(" 111 ");
		Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		
		
		System.out.println(" 111 ");
		Arrays.stream(grid).map(Arrays::toString).forEach(System.out::println);
		
		return grid[n - 1][m - 1];
	}
}
