package com.Target.Product.designpattern;

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
