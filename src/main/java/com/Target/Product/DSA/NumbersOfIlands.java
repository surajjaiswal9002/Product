package com.Target.Product.DSA;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int first;
	int last;
	
	Pair(int first, int last){
		this.first = first;
		this.last = last;
	}
}



public class NumbersOfIlands {
	public static void main(String[] args) {
		
		 char[][] gridLands = {
	                {'1', '1', '0', '0', '0'},
	                {'1', '1', '0', '0', '0'},
	                {'0', '0', '1', '0', '0'},
	                {'0', '0', '0', '1', '1'}
	        };
		 
		 
		 int n = gridLands.length;
		 int m = gridLands[0].length;
		 
		 int[][] visited = new int[n][m];
		 int count = 0;
		 
		 for(int i = 0; i < n; i++) {
			 for(int j = 0; j < m; j++) {
				 if(gridLands[i][j] == '1' && visited[i][j] == 0) {
					 count++;
					 bfs(gridLands, visited, i, j, n, m);
				 }
			 }
		 }
		 
		 System.out.println(" count : "+count);
		 
	}
	
	public static void bfs(char[][] grid, int[][] visited, int row, int col, int n, int m) {
		visited[row][col] = 1;
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(row, col));
		
		//direction
		int[] dirRow =  {1, -1, 0, 0};
		int[] dirCol = {0, 0, 1, -1};
		
		while(!q.isEmpty()) {
			
			Pair curr = q.poll();
			int row1 = curr.first;
			int col1 = curr.last;
			
			for(int i = 0; i < 4; i++) {
				
				int nRow = row1 + dirRow[i];
				int nCol = col1 + dirCol[i];
				
				while(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
					visited[nRow][nCol] = 1;
					q.add(new Pair(nRow, nCol));
				}
			}
		}
	}
}
