package com.Target.Product.Accloite;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AccuranceUsingJ8 {
    public static void main(String[] args) {

        String s = "helloworld";

        LinkedHashMap<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println(" accurance : " + map);

        Optional<Character> res = map.entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .map(Map.Entry::getKey).findFirst();

        if (res.isPresent()) {
            System.out.println(" res " + res);
        }
    }
}
