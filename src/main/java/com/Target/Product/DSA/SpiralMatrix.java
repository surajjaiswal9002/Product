package com.Target.Product.DSA;

import java.util.*;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		List<Integer> res =spiralMatrix(nums);
		System.out.println(" Spiral Matrix : "+res);
	}
	
	
	// tc - O(n*m) and sc - O(n*m)
	public static List<Integer> spiralMatrix(int[][] matrix){
		List<Integer> res = new ArrayList<>();
		
		if(matrix == null || matrix.length == 0) {
			return res;
		}
		
		int top = 0 , bottom = matrix.length -1;
		int left = 0, right = matrix[0].length - 1;
		
		while(top <= bottom && left <= right) {
			
			// left - right
			for(int i=left; i<=right;i++) {
				res.add(matrix[top][i]);
			}
			top++;
			
			// top - bottom
			for(int j = top; j <= bottom; j++) {
				res.add(matrix[j][right]);
			}
			right--;
			
			// top bottom
			if(top <= bottom) {
				// right left
				for(int i = right; i>=left; i--) {
					res.add(matrix[bottom][i]);
				}
				bottom--;
			}
		
			// bottom top
			if(left <= right) {
				for(int j = bottom; j>=top; j--) {
					res.add(matrix[j][left]);
				}
				left++;
			}
		}
		
		return res;
	}
}
