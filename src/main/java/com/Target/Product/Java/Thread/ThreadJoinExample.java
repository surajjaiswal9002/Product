package com.Target.Product.Java.Thread;

public class ThreadJoinExample {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
			try {
				System.out.println(" Thread Start ");
				Thread.sleep(1000); // sleep for 1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		
		t1.join(); // // MAIN THREAD waits here
		
		System.out.println(" Main Thread cintinue...");
		
		
		///Step-by-Step Output Flow
		//t1.start() → new thread starts
		//t1.join() → main thread waits
		//t1 completes after 2 seconds
		//Now main thread continues
		//Prints "Main thread continues..."
		
//		Inside join():
//			* The calling thread goes into WAITING state
//			* When the target thread finishes, JVM notifies the waiting thread
//			* The waiting thread becomes RUNNABLE again

	}
}
