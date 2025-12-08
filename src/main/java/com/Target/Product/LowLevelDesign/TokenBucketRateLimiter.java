package com.Target.Product.LowLevelDesign;

public class TokenBucketRateLimiter {
	
		private final long capacity;   // Bucket size
		private final long refilRate;  // refil Rate
		private long availableTokens;  // each token use - each request. if 2 req all per sec and user requested 4. it allowed first 2 request  rest 2 req will be dropped.
		private long lastRefillTimeNs;
		
		// constructor
		TokenBucketRateLimiter(long capacity, long refilRate){
			if(capacity <= 0 || refilRate <= 0) {
				 throw new IllegalArgumentException("capacity and refil rate must be positive.");
			}
			this.capacity = capacity;   // c
			this.refilRate = refilRate; // r
			this.availableTokens = capacity; // c
			this.lastRefillTimeNs = System.nanoTime();  // 
		}
		
	
		// allpwRequest
		public boolean allowRequest() {
			return tryConsume(1);
		}
		
		
		// tryconsume
		public synchronized boolean tryConsume(long numTokens) {
			if(numTokens <= 0) {
				throw new IllegalArgumentException();
			}
			
			refill();
			
			if(availableTokens >= numTokens) {
				availableTokens = availableTokens - numTokens;
				return true;
			}
			
			return false;
		}
		
		// refills
		public void refill() {
			long now = System.nanoTime();
			long elapsedTime = now - lastRefillTimeNs;
			
			// Convert nanoseconds to seconds and calculate tokens to add
			long tokensToAdd = (elapsedTime * refilRate) / 1_000_000_000;
			if(tokensToAdd > 0) {
				availableTokens = Math.min(capacity, availableTokens + tokensToAdd);
				lastRefillTimeNs = now;
			}
			
		}
		
		//  getAvailableToken
		public synchronized long getAvailableTokens() {
			refill();
			return availableTokens;
		}
		
		
		public static void main(String[] args) throws InterruptedException {
			// Create rate limiter: 10 tokens capacity, 2 tokens per second refill
			TokenBucketRateLimiter bucket = new TokenBucketRateLimiter(10, 2);  
			
			for(int i = 1; i <= 10; i++) {
				boolean allowed = bucket.allowRequest();
				 System.out.printf("Request %d: %s (Available:x %d)%n", 
			                i, allowed ? "ALLOWED" : "DENIED", bucket.getAvailableTokens());
				   	
				 Thread.sleep(300); // wait 0.3s between requests
			}
			
			
			// 11th request should fail
	        System.out.println("\n11th request (should fail):");
	        boolean allowed = bucket.allowRequest();
	        System.out.printf("Request 11: %s (Available: %d)%n", 
	            allowed ? "ALLOWED" : "DENIED", bucket.getAvailableTokens());
	        
	        
	        // Wait for refill
	        System.out.println("\nWaiting 2 seconds for refill...");
	        Thread.sleep(2000);

	     // Try requests again
	        System.out.println("\nNew requests after refill:");
	        for (int i = 1; i <= 5; i++) {
	            allowed = bucket.allowRequest();
	            System.out.printf("Request %d: %s (Available: %d)%n", 
	                i, allowed ? "ALLOWED" : "DENIED", bucket.getAvailableTokens());
	        }
		}
		
}
