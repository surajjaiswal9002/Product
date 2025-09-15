package com.Target.Product.SystemOriendedDSA;

import java.util.*;

public class RateLimiterSlidingWindow {

	private final int maxRequest;
	private final long windowSizeInMillis;
	private final Deque<Long> requestTimeStamps;
	
	public RateLimiterSlidingWindow(int maxRequest, long windowSizeInMillis) {
		this.maxRequest = maxRequest;
		this.windowSizeInMillis = windowSizeInMillis;
		this.requestTimeStamps = new ArrayDeque<Long>();
	}
	
	
	public synchronized boolean allowRequest() {
		long now = System.currentTimeMillis();
		
		while(!requestTimeStamps.isEmpty() && now - requestTimeStamps.peekFirst() >= windowSizeInMillis) {
			requestTimeStamps.pollFirst();
		}
		
		if(requestTimeStamps.size() < maxRequest) {
			requestTimeStamps.add(now);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		RateLimiterSlidingWindow rateLimiter = new RateLimiterSlidingWindow(3, 1000);
		
		for(int i =0; i < 5; i++) {
			System.out.println(" Request "+(i+1)+"  allowed? "+rateLimiter.allowRequest());
			Thread.sleep(200);
		}
		

	}

}
