package com.Target.Product.Gold;

import java.util.LinkedList;
import java.util.Queue;

class pair{
	int first;
	int last;
	
	pair(int first, int last){
		this.first = first;
		this.last = last;
	}
}


public class NumberOfIlands {
	public static void main(String[] args) {
		String[][] grid = {
		        {"1","1","1","1","0"},
		        {"1","1","0","1","0"},
		        {"1","1","0","0","0"},
		        {"0","0","0","0","0"}};
		
		
		int n = grid.length;
		int m = grid[0].length;
		
		int countNumOfIlands = 0;
		
		int[][] visited = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == "1" && visited[i][j] == 0) {
					countNumOfIlands++;
					bfs(grid, visited, i, j, n, m);
				}
			}
		}
		
		
		System.out.println(" Number of Ilands : "+countNumOfIlands);
	}
	
	public static void bfs(String[][] grid, int[][] visited, int row, int col, int n, int m) {
		visited[row][col] = 1;
		Queue<pair> queue = new LinkedList<pair>();
		queue.add(new pair(row, col));
		
		int[] rowDir = {1, -1, 0, 0};
		int[] colDir = {0, 0, 1, -1};
		
		while(!queue.isEmpty()) {
			
			pair curr = queue.poll();
			int row1 = curr.first;
			int col1 = curr.last;
			
			for(int i = 0; i < 4; i++) {
				int nRow = row1 + rowDir[i];
				int nCol = col1 + colDir[i];
				
				if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == "1" && visited[nRow][nCol] == 0) {
					visited[nRow][nCol] = 1;
					queue.add(new pair(nRow, nCol));
				}
			}
		}
		
	}
}
