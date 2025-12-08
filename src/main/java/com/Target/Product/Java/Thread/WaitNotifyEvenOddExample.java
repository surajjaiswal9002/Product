package com.Target.Product.Java.Thread;

public class WaitNotifyEvenOddExample {
	private int number = 1;
	private final int limit = 10;
	
	
	public synchronized void printOdd() {
		while(number <= limit) {
			while(number % 2 == 0) {  // if even wait
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(" odd = "+number);
			number++;
			notify();  // wake to even thread
		}
	}
	
	
	public synchronized void printEven() {
		while(number <= limit) {
			while(number % 2 != 0) {  //if odd wait
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(" Even = "+number);
			number++;
			
			notify();  // wake to odd number
		}
	}
	
	
	public static void main(String[] args) {
		
		WaitNotifyEvenOddExample w = new WaitNotifyEvenOddExample();
		
		Thread oddThread = new Thread(() ->{
			w.printOdd();
		});
		
		Thread evenThread = new Thread(() -> {
			w.printEven();
		});
		
		oddThread.start();
		evenThread.start();
	}
}
