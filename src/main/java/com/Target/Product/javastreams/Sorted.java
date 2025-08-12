package com.Target.Product.javastreams;

import java.util.*;

public class Sorted {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Nobita", "Jhon", "Kelly", "Mikel");

        List<String> reverseName = names.stream().sorted(Comparator.reverseOrder()).toList();

        System.out.println(" result : " + reverseName);
    }
}
