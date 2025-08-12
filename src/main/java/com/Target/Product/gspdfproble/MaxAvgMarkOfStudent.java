package com.Target.Product.gspdfproble;

import java.util.*;


// Tc - o(n) and sc - O(n)
public class MaxAvgMarkOfStudent {
    public static void main(String[] args) {
        String[][] A = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"},
                {"Jessica", "99"}};

        double maxAvgMark = findMaxAvgMark(A);
        System.out.println("maxAvgMark : " + maxAvgMark);
    }

    public static double findMaxAvgMark(String[][] A) {
        Map<String, List<Integer>> groupOfMap = new HashMap<>();

        for (String[] s : A) {

            String name = s[0];
            int mark = Integer.parseInt(s[1]);

            groupOfMap.putIfAbsent(name, new ArrayList<>());
            groupOfMap.get(name).add(mark);
        }

        System.out.println(groupOfMap);
        double maxAvg = 0;
        for (Map.Entry<String, List<Integer>> entries : groupOfMap.entrySet()) {
            List<Integer> entry = entries.getValue();

            double sum = 0;

            for (int n : entry) {
                sum += n;
            }

            double avg = sum / entry.size();
            maxAvg = Math.max(maxAvg, avg);
        }


        return maxAvg;

    }
}
