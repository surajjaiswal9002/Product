package com.Target.Product.Java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Person {
    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}

public class MaxWithIdAndNameTogether {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person(101, "Alice"),
            new Person(205, "Bob"),
            new Person(150, "Charlie"),
            new Person(205, "David")
        );

        // Find person with max id, and if tie, max name
        Optional<Person> maxPerson = persons.stream()
            .max(Comparator.comparingInt((Person p) -> p.id)
                           .thenComparing(p -> p.name));
        
        
        // Sort using stream and find the last element
        Optional<Person> maxPerson1 = persons.stream()
            .sorted(Comparator.comparingInt((Person p) -> p.id)
                              .thenComparing(p -> p.name))
            .reduce((first, second) -> second); // Get the last element

        
        maxPerson.ifPresent(person -> 
            System.out.println("Person with max id and name: " + person));

        maxPerson.ifPresent(person -> 
            System.out.println("Person with max id and name: " + person));
    }
}

