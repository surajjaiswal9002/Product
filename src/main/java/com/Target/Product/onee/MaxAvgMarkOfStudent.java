package com.Target.Product.onee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAvgMarkOfStudent {
    public static void main(String[] args) {

        String[][] A = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"},
                {"Jessica", "99"}};

        double avgMark = findMaxAvgMark(A);
        System.out.println(avgMark);
    }

    public static double findMaxAvgMark(String[][] A) {
        Map<String, List<Integer>> groupOfMap = new HashMap<>();

        for (String[] s : A) {

            String word = s[0];
            int mark = Integer.parseInt(s[1]);

            groupOfMap.putIfAbsent(word, new ArrayList<>());
            groupOfMap.get(word).add(mark);
        }
        System.out.println(groupOfMap);
        double maxAvg = 0;
        for (Map.Entry<String, List<Integer>> entry : groupOfMap.entrySet()) {
            List<Integer> list = entry.getValue();
            int sum = 0;
            for (int n : list) {
                sum = sum + n;
            }

            double avg = sum / list.size();
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}
