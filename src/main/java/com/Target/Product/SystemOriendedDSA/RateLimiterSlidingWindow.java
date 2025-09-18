package com.Target.Product.SystemOriendedDSA;

import java.util.*;

public class RateLimiterSlidingWindow {
	private final int maxRequest;
	private final long windowSizeMillis;
	private final Deque<Long> requestTimeStamps;
	
	public RateLimiterSlidingWindow(int maxRequest, long windowSizeMillis) {
		this.maxRequest = maxRequest;
		this.windowSizeMillis = windowSizeMillis;
		this.requestTimeStamps = new ArrayDeque<Long>();
	}
	
	
	public synchronized boolean allowRequest() {
		long now = System.currentTimeMillis();
		
		while(!requestTimeStamps.isEmpty() && now - requestTimeStamps.peekFirst() >= windowSizeMillis) {
			requestTimeStamps.pollFirst();
		}
		
		if(requestTimeStamps.size() < maxRequest) {
			requestTimeStamps.addLast(now);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		RateLimiterSlidingWindow limiter = new RateLimiterSlidingWindow(3, 1000);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(" Request "+(i + 1)+" allowed? "+limiter.allowRequest());
			Thread.sleep(2000);
		}
		

	}

}
