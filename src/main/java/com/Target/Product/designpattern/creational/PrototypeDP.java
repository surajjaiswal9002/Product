package com.Target.Product.designpattern.creational;



//Prototype is a creational design pattern that lets you copy existing objects 
// without making your code dependent on their classes.

import java.util.HashMap;
import java.util.Map;

// Step 1: Prototype Interface
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Step 2: Concrete Prototypes
class Circle implements Shape {
    public void draw() { System.out.println("Circle drawn"); }
    public Shape clone() { return new Circle(); }
}

class Square implements Shape {
    public void draw() { System.out.println("Square drawn"); }
    public Shape clone() { return new Square(); }
}

// Step 3: Prototype Registry
class ShapeRegistry {
    private static Map<String, Shape> registry = new HashMap<>();

    static {
        registry.put("circle", new Circle());
        registry.put("square", new Square());
    }

    public static Shape getShape(String type) {
        Shape prototype = registry.get(type);
        return prototype.clone(); // clone hides concrete type
    }
}

// Step 4: Client Code
public class PrototypeDP {
    public static void main(String[] args) {
        Shape shape1 = ShapeRegistry.getShape("circle");
        Shape shape2 = ShapeRegistry.getShape("square");

        shape1.draw(); // client doesn’t know what class it is
        shape2.draw();
    }
}



