package com.Target.Product.Java.Thread;

public class ByImplementationRunnableInteface implements Runnable{
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
		System.out.println(Thread.currentThread().getName()+" - "+i);
			try {
				Thread.sleep(1000);  // sleep for 1000 ms
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Thread t2 = new Thread(new ByImplementationRunnableInteface());
		t2.start();
	}
}
