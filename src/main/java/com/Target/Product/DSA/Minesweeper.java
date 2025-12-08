package com.Target.Product.DSA;

import java.util.LinkedList;
import java.util.Queue;

//class Pair{
//	int first;
//	int last;
//	
//	Pair(int first, int last){
//		this.first = first;
//		this.last = last;
//	}
//}


public class Minesweeper {
	public static void main(String[] args) {
		char[][] grid = {
	            {'.', '*', '.'},
	            {'.', '.', '*'},
	            {'*', '.', '.'}
	        };
		
		int n = grid.length;
		int m = grid[0].length;
		int[][] result = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == '*') {
					result[i][j] = -1;
				}else {
					result[i][j] = bfsMinesweeper(grid, i, j, n, m);
				}
			}
		}
		
		// print result
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(result[i][j] == -1) {
					System.out.print("* ");
				}else {
					System.out.print(result[i][j]+" ");
				}	
			}
			System.out.println();
		}
	}
	
	
	public static int bfsMinesweeper(char[][] grid, int row, int col, int m, int n) {
		int count = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(row, col));
		
		int[] dirRow = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dirCol = {-1,  0,  1,-1, 1,-1, 0, 1};
		
		while(!q.isEmpty()) {
			
			Pair curr = q.poll();
			int row1 = curr.first;
			int col1 = curr.last;
			
			for(int i = 0; i < 8; i++) {
				int nRow = row1 + dirRow[i];
				int nCol = col1 + dirCol[i];
				
				if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '*') {
					count++;
				}
			}
		}
		
		return count;
	}
}
