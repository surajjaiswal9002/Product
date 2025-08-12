package com.Target.Product.sheetdsaproblems;

import java.util.Objects;

// Player class
class Player {
    int id;
    String name;

    // constructor
    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    public String toString() {
        return "Player = {" + "id = " + id + ", name = " + name + "}";
    }

    // equals
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null && o.getClass() == getClass()) return false;
        return false;
    }

    // hashcode
    public int hashCode(){
        return Objects.hash(id, name);
    }
}
// Node class

// PlayerList class


public class CustomLinkedListJava {
    public static void main(String[] args) {

    }
}
