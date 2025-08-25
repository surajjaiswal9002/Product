package com.Target.Product.gspdfproble;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 23, 4, 0, 6};
        moveZeros(arr);
        moveZerosFow(arr);
    }

    public static void moveZeros(int[] arr) {
        int k = arr.length -1 ;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[k--] = arr[i];
            }
        }

        System.out.println(" -- "+Arrays.toString(arr));
        
         for (int i = k; i >= 0; i--) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));

    }
    
    public static void moveZerosFow(int[] arr) {
        int k = 0; // points to next position for non-zero

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];  // move non-zero forward
            }
        }

        // fill remaining with zeros
        while (k < arr.length) {
            arr[k++] = 0;
        }
        
        System.out.println(Arrays.toString(arr));
    }
}
