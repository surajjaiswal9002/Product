package com.Target.Product.Java;

import java.util.concurrent.*;



//What is ExecutorService?
//
//A high-level API to manage threads.
//
//You don’t create threads manually; the service handles a thread pool for you.
//
//Supports Runnable (no return) and Callable (returns result).
public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit Runnable tasks
        Runnable task1 = () -> {
            System.out.println("Runnable Task 1 executed by: " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            System.out.println("Runnable Task 2 executed by: " + Thread.currentThread().getName());
        };

        executor.submit(task1);
        executor.submit(task2);

        // Submit Callable task
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable Task executed by: " + Thread.currentThread().getName());
            return 42;
        };

        Future<Integer> future = executor.submit(callableTask);

        // Get result from Callable
        Integer result = future.get();
        System.out.println("Callable result: " + result);

        // Shutdown executor
        executor.shutdown();
        System.out.println("Executor shutdown");
    }
}
