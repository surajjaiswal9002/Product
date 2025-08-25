package com.Target.Product.ThreadExample;


class MyRunnable implements Runnable {

    private String taskName;

    public MyRunnable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
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

public class ByImplementsRunnableThread {

	public static void main(String[] args) {
        MyRunnable task1 = new MyRunnable("Runnable-1");
        MyRunnable task2 = new MyRunnable("Runnable-2");

        // Wrap Runnable inside Thread
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        System.out.println("Main thread finished!");
    }

}
