package com.Target.Product.gspdfproble;

public class RockCollectUpLeft {
    public static void main(String[] args) {
        int[][] gridRock = {
                {0, 2, 2, 1},
                {3, 1, 1, 0},
                {4, 0, 1, 2},
        };


        int maxRock = maxRockCollect(gridRock);

        System.out.println(" maxRock : " + maxRock);
    }

    public static int maxRockCollect(int[][] gridRock) {
        int row = gridRock.length;
        int col = gridRock[0].length;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                int fromBelow = (i + 1 < row) ? gridRock[i + 1][j] : 0;
                int fromLeft = (j - 1 >= 0) ? gridRock[i][j - 1] : 0;

                gridRock[i][j] += Math.max(fromBelow, fromLeft);
            }
        }


        return gridRock[0][col - 1];
    }
}
