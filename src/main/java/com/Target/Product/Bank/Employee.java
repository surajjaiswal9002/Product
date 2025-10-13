package com.Target.Product.Bank;


class Employee {

    private int id;
    private String name;
 
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
 

	public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    @Override

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id == employee.id; // Comparing based on ID for uniqueness

    }
 
    @Override

    public int hashCode() {

        return id; // Hashing based on ID

    }
 
    @Override

    public String toString() {

        return "Employee{" +

               "id=" + id +

               ", name='" + name + '\'' +

               '}';

    }

}