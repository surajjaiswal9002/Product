package com.Target.Product.gspdfproble;

import java.util.*;


// tc - O(n) and sc -O(n)
public class MergeOverlap {
    public static void main(String[] args) {

        int[][] arr = {{1,3},{2,4},{6,8},{9,10}};

        List<int[]> list = mergeOverLap(arr);

        for(int[] i : list){
            System.out.println(Arrays.toString(i));
        }

    }

    public static List<int[]> mergeOverLap(int[][] arr){

        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        list.add(new int[] {arr[0][0], arr[0][1]});

        for(int i = 1; i < n; i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = arr[i];

            if(curr[0] < last[1]){
                last[1] = Math.max(last[1], curr[1]);
            }else{
                list.add(new int[] {curr[0], curr[1]});
            }
        }

        return list;
    }
}
