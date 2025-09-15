package com.Target.Product.Java;

import java.util.concurrent.*;

public class FailSafeDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String s : list) {
            System.out.println(s);
            list.add("D"); // Safe, no exception
        }

        System.out.println("Final List: " + list);
    }
}
