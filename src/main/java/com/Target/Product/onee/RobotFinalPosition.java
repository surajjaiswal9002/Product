package com.Target.Product.onee;

import java.util.Arrays;

public class RobotFinalPosition {
    public static void main(String[] args) {

        String path1 = "UUDD";

        int[] path = getFinalPosition(path1);

        System.out.println(" Path : " + Arrays.toString(path));
    }

    public static int[] getFinalPosition(String path) {
        int x = 0, y = 0;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'U':
                    y++;
                    break;
                case 'L':
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'R':
                    x--;
                    break;
            }
        }

        return new int[]{x, y};
    }
}
