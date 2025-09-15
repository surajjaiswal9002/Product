package com.Target.Product.DSA001;

class Task implements Runnable {
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Stopped.");
    }
}

public class VolatileInterviewExample {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread worker = new Thread(task);
        
        worker.start();
        
        Thread.sleep(3000); // Let the worker run for a few seconds
        
        System.out.println("Stopping the worker...");
        task.stop = true; // This change is immediately visible to the worker
        
        worker.join();
        System.out.println("Worker has stopped.");
    }
}
