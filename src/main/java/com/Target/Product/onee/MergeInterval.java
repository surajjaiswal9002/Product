package com.Target.Product.onee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};

       List<int[]> res = mergeIntervals(intervals);

       for(int[] i : res){
           System.out.println(" "+Arrays.toString(i));
       }

    }

    public static List<int[]> mergeIntervals(int[][] intervals){

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] last = res.get(res.size() - 1);

            if(curr[0] <= last[1]){
                last[1] = Math.max(last[i], curr[i]);
            }else{
                res.add(new int[]{curr[0], curr[1]});
            }
        }

        return res;

    }


}
