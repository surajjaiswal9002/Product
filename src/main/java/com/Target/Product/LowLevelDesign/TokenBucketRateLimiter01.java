package com.Target.Product.LowLevelDesign;



public class TokenBucketRateLimiter01 {
	private final long capacity;
	private final long refilRate;
	private long availableTokens;
	private long rateLimitTimeNs;
	
	TokenBucketRateLimiter01(long capacity, long refilRate){
		if(capacity <= 0 || refilRate <= 0) {
			throw new IllegalArgumentException(" Capacity and refilRate should be positive.");
		}
		
		this.capacity = capacity;
		this.refilRate = refilRate;
		this.availableTokens = capacity;
		this.rateLimitTimeNs = System.nanoTime();
	}
	
	
	//availableReq
	public boolean allowedRequest() {
		return tryConsume(1);
	}
	
	
	//tokenConsume
	public synchronized boolean tryConsume(int tokens) {
		if(tokens <= 0) {
			throw new IllegalArgumentException(" token should be positive ");
		}
		
		refills();
		
		if(availableTokens >= tokens) {
			availableTokens = availableTokens - tokens;
			return true;
		}
		
		return false;
	}
	
	// refill
	public void refills() {
		long now = System.nanoTime();
		long eTime = now - rateLimitTimeNs;
		
		long tokenToAdd = (eTime * refilRate) / 1_000_000_000;
		if(tokenToAdd > 0) {
			availableTokens = Math.min(tokenToAdd + availableTokens , capacity);
			rateLimitTimeNs = now;
		}
		
	}
	
	// getAvailable
	public synchronized long getAvaibility() {
		refills();
		return availableTokens;
	}
	
	
	public static void main(String[] args) {
		TokenBucketRateLimiter01 bucket = new TokenBucketRateLimiter01(10, 2);
		
		for(int i = 1; i <= 10; i++) {
			boolean allowed = bucket.allowedRequest();
			System.out.printf(" Request %d : %s (Allowed: %d)%n ", i, allowed ? "ALLOWED" : "DENIED", bucket.getAvaibility());
		}
		
	}
}
