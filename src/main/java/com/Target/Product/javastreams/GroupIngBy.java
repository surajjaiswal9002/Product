package com.Target.Product.javastreams;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    String city;

    Person(String name, String city) {
        this.name = name;
        this.city = city;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int hashCode() {
        return Objects.hash(name, city);
    }


    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;
        return Objects.equals(name, that.name) && Objects.equals(city, that.city);
    }

}

public class GroupIngBy {
    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                new Person("amit", "jhasi"),
                new Person("sumit", "bbsr"),
                new Person("riush", "banglore"),
                new Person("kavita", "chennai")


        );

        Map<String, List<Person>> result = list.stream().collect(Collectors.groupingBy(Person::getCity));

        for (Map.Entry<String, List<Person>> entrys : result.entrySet()) {
            List<Person> entry = entrys.getValue();

            for (Person n : entry) {
                System.out.println("name : " + n.getName() + ", city - " + n.getCity());
            }
        }
    }
}
