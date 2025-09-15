package com.Target.Product.Java;
import java.util.*;



class Data {
    int id;
    String name;
    double salary;

    Data(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data d = (Data) o;
        return id == d.id &&
               Double.compare(d.salary, salary) == 0 &&
               name.equals(d.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}



public class SetScenarioExample {
	    public static void main(String[] args) {
	        Set<Data> set = new HashSet<>();

	        set.add(new Data(1, "Alice", 1000));
	        set.add(new Data(1, "Alice", 1000)); // duplicate
	        set.add(new Data(1, "Alice", 1000)); // duplicate
	        set.add(new Data(2, "Bob", 2000));   // unique
	        set.add(new Data(3, "Charlie", 3000)); // unique

	        System.out.println("Set size: " + set.size());
	        System.out.println(set);
	    }
	}

