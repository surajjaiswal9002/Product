package com.Target.Product.ThreadExample;

class MyThread extends Thread {

    private String taskName;

    public MyThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public synchronized void run() {
        // logic for the thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(1000); // pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
        System.out.println(taskName + " finished!");
    }
}


public class ByExtendingThread {
	 public static void main(String[] args) {
	        MyThread t1 = new MyThread("Thread-1");
	        MyThread t2 = new MyThread("Thread-2");

	        // start threads
	        t1.start();
	        t2.start();

	        System.out.println("Main thread finished!");
	    }
}
