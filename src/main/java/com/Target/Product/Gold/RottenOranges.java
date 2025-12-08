package com.Target.Product.Gold;

import java.util.*;

class Cell{
	
	int first;
	int last;
	int time;
	
	Cell(int first, int last, int time){
		this.first = first;
		this.last = last;
		this.time = time;
	}
	
}


public class RottenOranges {
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		int ans = rottenOranges(grid);
		System.out.println(" Rotten Oranges : "+ans);
	}
	
	public static int rottenOranges(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		int rottenCount = 0;
		Queue<Cell> queue = new LinkedList<Cell>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Cell(i, j, 0));
				}
				
				if(grid[i][j] == 1) {
					rottenCount++;
				}
			}
		}
		
		if(rottenCount == 0) return 0;  // base case
		
		
		int time = 0;
		
		// direction
		int[] dirRow = {-1, 1, 0, 0};
		int[] dirCol = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			
			Cell curr = queue.poll();
			int row1 = curr.first;
			int col1 = curr.last;
			time = curr.time;
			
			for(int i = 0; i < 4; i++) {
				int nRow = row1 + dirRow[i];
				int nCol = col1 + dirCol[i];
				
				
				if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
					rottenCount--;
					grid[nRow][nCol] = 2;
					queue.add(new Cell(nRow, nCol, time + 1));
				}
			}
		}
		
		
		return rottenCount == 0 ? time : 0;
		
		
		
	}
}
