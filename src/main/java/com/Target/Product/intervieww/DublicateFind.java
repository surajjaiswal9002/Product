package com.Target.Product.intervieww;


import java.util.*;
import java.util.stream.Collectors;

public class DublicateFind {
    public static void main(String[] args) {
        int[ ] arr = {2,3,4,3,5,6,4,7,8,5};

        Set<Integer> set = new HashSet<>();
        Set<Integer> dublicate = new HashSet<>();


        //set // 2, 3, 4, 3
        // dublicate
        for(int i = 0; i < arr.length;i++){
           if(!set.add(arr[i])){   // 2
               dublicate.add(arr[i]);
           }

        }

        System.out.println(set);

        System.out.println(dublicate);


        // Java 8

        List<Integer> ans = Arrays.stream(arr).boxed().distinct().sorted().toList();
        Set<Integer> set1 = new HashSet<>();
        List<Integer> res = Arrays.stream(arr).boxed().filter( n -> !set1.add(n)).toList();

        System.out.println(res);


    }
}
