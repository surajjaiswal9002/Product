package com.Target.Product.designpattern.creational;


// Factory Method is a creational design pattern that provides an interface for creating objects in a 
//superclass, but allows subclasses to alter the type of objects that will be created.

//interface
interface vechile{

    void drive();
}

class Car implements vechile{

    @Override
    public void drive(){
        System.out.println(" Driving a car");
    }


}


class Bike implements vechile{

    @Override
    public void drive(){
        System.out.println(" Driving a Bike");
    }


}


public class FactoryDesignPattern {

    public static vechile getVechile(String vech){

        switch(vech.toLowerCase()){
            case "car": return new Car();
            case "bike" : return new Bike();
            default : throw new  IllegalArgumentException(" Not found");
        }
    }

    public static void main(String[] args) {

        vechile v = getVechile("bike");
        v.drive();
    }
}



