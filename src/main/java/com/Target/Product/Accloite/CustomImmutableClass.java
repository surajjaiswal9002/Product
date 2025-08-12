package com.Target.Product.Accloite;

import java.util.Objects;

public class CustomImmutableClass {

    private String name;
    private int id;

    CustomImmutableClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

   @Override
    public int hashCode(){
        return Objects.hash(name, id);
   }

   @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()) return false;
       CustomImmutableClass that = (CustomImmutableClass) o;
       return that.id == id && Objects.equals(that.name, name);
   }
}
