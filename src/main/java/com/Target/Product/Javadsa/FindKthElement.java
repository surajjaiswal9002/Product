package com.Target.Product.Javadsa;

public class FindKthElement {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        int result = findKthElement(arr1, arr2, k);
        System.out.println("Kth element is: " + result);
    }

    
    public static int findKthElement(int[] arr1, int[] arr2, int k){
        int i = 0; int j = 0; int count = 0;

        while(i < arr1.length && j < arr2.length){
            int val;
            if(arr1[i] < arr2[j]){
                val = arr1[i++];
            }else{
                val = arr2[j++];
            }

            count++;
            if(count == k) return val;
        }


        while(i < arr1.length){
            count++;
            if(count == k) return arr1[i];
            i++;
        }


        while(j < arr2.length){
            count++;
            if(count == k) return arr2[j];
            j++;
        }

        return -1;

    }
}
