package com.Target.Product.SpringBoot;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
		
	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
	public void callExternalervices() {
		 System.out.println("Calling external service...");
	     throw new RuntimeException("Service not available");
	}
	 
	 
}
