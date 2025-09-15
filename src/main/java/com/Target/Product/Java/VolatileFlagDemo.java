package com.Target.Product.Java;

public class VolatileFlagDemo {
	
	private volatile boolean running = true;
	
	public void start() {
		System.out.println(" Worker thread started...");
		
		while(running) {
			// do some things
		}
		
		System.out.println(" Worker thread stop");
	}
	
	
	public void stop() {
		running = false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileFlagDemo v = new VolatileFlagDemo();
		
		Thread t = new Thread(v::start);
		t.start();
		
		Thread.sleep(1000);
		
		v.stop();
	}
}
