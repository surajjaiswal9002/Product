package com.Target.Product.Java;

public class GarbageCollectionExample {
    public static void main(String[] args) {
    	GarbageCollectionExample obj1 = new GarbageCollectionExample();
    	GarbageCollectionExample obj2 = new GarbageCollectionExample();

        obj1 = null;
        obj2 = null;

        // Suggest JVM to run GC
        System.gc();
    }

    @Override
    protected void finalize() {
        System.out.println("Garbage collected: " + this);
    }
}

