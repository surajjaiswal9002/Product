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
		VolatileFlagDemo vilatile = new VolatileFlagDemo();
		
		Thread thread = new Thread(vilatile :: start);
		thread.start();
		
		Thread.sleep(1000);
		
		vilatile.stop();
	}
}
