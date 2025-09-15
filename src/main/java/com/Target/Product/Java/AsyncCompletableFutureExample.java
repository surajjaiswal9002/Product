package com.Target.Product.Java;

import java.util.concurrent.CompletableFuture;

public class AsyncCompletableFutureExample {
	public static void main(String[] args) {

		System.out.println(" Start : ");

		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(" Exception ** ");
			}

			return "Hello Suraj";
		});

		
		
		async.thenAccept(res -> System.out.println(res)).join();
	}
}
