package com.Target.Product.Java;

class SyncCounter {
    private int count = 0;

    // synchronized method
    public synchronized void increment() {
        count++; // atomic now
    }

    public synchronized int getCount() {
        return count;
    }
}

public class WithSyncDemo {
    public static void main(String[] args) throws InterruptedException {
        SyncCounter counter = new SyncCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count = " + counter.getCount()); // always 2000
    }
}
