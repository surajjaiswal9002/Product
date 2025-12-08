package com.Target.Product.DSA;

import java.util.LinkedList;
import java.util.Queue;

class cell{
	int row;
	int col;
	int time;
	
	cell(int row, int col, int time){
		this.row = row;
		this.col = col;
		this.time = time;
	}
}

// TC - O(n * m) and sc - O(n * m)
public class RottenOrange {
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		
		int ans = orangeRotten(grid);
		System.out.println("Minimum time to rot the orange : "+ans);
	}
	
	public static int orangeRotten(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		Queue<cell> q = new LinkedList<>();
		int rottingCount = 0;
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 2) {   // 2
					q.add(new cell(i, j, 0));
				}
				
				if(grid[i][j] == 1) {  // 1
					rottingCount++;
				}
			}
		}
		
		
		if(rottingCount == 0) return 0;  // base case
		
		int time = 0;
		int[] dirRow = {1, -1, 0, 0};
		int[] dirCol = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			
			cell curr = q.poll();
			time = curr.time;
			
			for(int i = 0; i < 4; i++) {
				int nRow = curr.row + dirRow[i];
				int nCol = curr.col + dirCol[i];
				
				if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m && grid[nRow][nCol] == 1) {
					grid[nRow][nCol] = 2;
					rottingCount--;
					q.add(new cell(nRow, nCol, curr.time + 1));
				}
			}
		}
		
		return rottingCount == 0 ? time : 0;
	}
}
