package com.Target.Product.Java.Thread;

public class ByExtendingThread extends Thread{
	
	public void run(){
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+" - "+i);
			
			try {
				Thread.sleep(1000);  // sleep for 1 Sec
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		ByExtendingThread t1 = new ByExtendingThread();
		t1.start();
	}
}
