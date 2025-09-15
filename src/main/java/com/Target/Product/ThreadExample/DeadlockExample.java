package com.Target.Product.ThreadExample;

public class DeadlockExample {

    // Two resources (locks)
    private final Object resourceA = new Object();
    private final Object resourceB = new Object();

    public void method1() {
        synchronized (resourceA) {
            System.out.println("Thread 1: Locked resource A");

            try {
                Thread.sleep(100); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1: Waiting to lock resource B");

            synchronized (resourceB) {
                System.out.println("Thread 1: Locked resource B");
            }
        }
    }

    public void method2() {
        synchronized (resourceB) {
            System.out.println("Thread 2: Locked resource B");

            try {
                Thread.sleep(100); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 2: Waiting to lock resource A");

            synchronized (resourceA) {
                System.out.println("Thread 2: Locked resource A");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        // Thread 1 runs method1
        Thread t1 = new Thread(example::method1);

        // Thread 2 runs method2
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }
}
