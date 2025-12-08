package com.Target.Product.Java.Thread;


import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    // Producer adds items
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer full... Producer waiting");
            wait();     // wait until consumer consumes
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notifyAll();   // wake all consumers
    }

    // Consumer removes items
    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer empty... Consumer waiting");
            wait();     // wait until producer adds
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        notifyAll();    // wake all producers
    }
}

public class NotifyAllExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Multiple Producers
        Runnable producerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) { }
            }
        };

        // Multiple Consumers
        Runnable consumerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) { }
            }
        };

        Thread p1 = new Thread(producerTask);
        Thread p2 = new Thread(producerTask);

        Thread c1 = new Thread(consumerTask);
        Thread c2 = new Thread(consumerTask);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
