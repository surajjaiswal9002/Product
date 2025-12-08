package com.Target.Product.Java.Thread;

class Counter{
	int count = 0;
	
	// method level synchronized
	public synchronized void increament() {
		count++;
	}
	
	// block level synchronized
	public void decreament() {
		synchronized(this) {
			count--;
		}
		
	}
	
	public int getCount() {
		return count;
	}
}

public class SynchrozationExample {
	public static void main(String[] args) {
		Counter c = new Counter();
		c.increament();
		c.increament();
		c.decreament();
		System.out.println(" count = "+
		c.getCount());
	}
}
