package com.Target.Product.Java;

public class DeadlockExample {
    public static void main(String[] args) {

        final Object resource1 = "Resource 1";
        final Object resource2 = "Resource 2";

        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked Resource 1");

                try {
                	Thread.sleep(100); 
                	} catch(Exception e) {
                		
                	}

                synchronized (resource2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked Resource 2");

                try { Thread.sleep(100); } catch(Exception e) {}

                synchronized (resource1) {
                    System.out.println("Thread 2 locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}



 class DeadlockResolved {
    public static void main(String[] args) {

        final Object resource1 = "Resource 1";
        final Object resource2 = "Resource 2";

        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked Resource 1");
                synchronized (resource2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        // Thread 2 (same lock order)
        Thread t2 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 2 locked Resource 1");
                synchronized (resource2) {
                    System.out.println("Thread 2 locked Resource 2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

