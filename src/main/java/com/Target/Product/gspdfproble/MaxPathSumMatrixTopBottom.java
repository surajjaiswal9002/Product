package com.Target.Product.gspdfproble;

import java.util.Arrays;

public class MaxPathSumMatrixTopBottom {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}
        };

        int n = mat.length;
        int m = mat[0].length;
        int maxPathSum = Integer.MIN_VALUE;


        for (int j = 0; j < m; j++) {
            maxPathSum = Math.max(maxPathSum, findMaxPathSum(mat, 0, j, n, m));
        }

        System.out.println(maxPathSum);
    }

    public static int findMaxPathSum(int[][] mat,  int r, int c, int n, int m){
        if(c < 0 || c >= m){
            return -1;
        }

        if(r == n - 1){
            return mat[r][c];
        }


       int down =  findMaxPathSum(mat, r+1, c, n, m);
        int downLeft =  findMaxPathSum(mat,  r+1, c-1, n, m);
        int downRight =  findMaxPathSum(mat,  r+1, c+1, n, m);



        return mat[r][c] + Math.max(down, Math.max(downLeft, downRight));

    }
}
