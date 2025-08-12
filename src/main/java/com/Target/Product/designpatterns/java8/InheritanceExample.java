package com.Target.Product.designpatterns.java8;


class A{

    void show(String s ){
        System.out.println(" A --> String "+s);
    }

    void show(Object o){
        System.out.println(" A --> Object "+o);
    }
}


class B extends A{

    void show(String s ){
        System.out.println(" B --> String "+s);
    }

    void show(int i){
        System.out.println(" B --> int "+i);
    }
}


public class InheritanceExample {

    public static void main(String[] args) {

        A a = new B();
        a.show(1);
        a.show("sigmoid");

        System.out.println(" ______________  ");
        B b = new B();
        b.show(1);
        b.show("sigmoid");
    }
}
