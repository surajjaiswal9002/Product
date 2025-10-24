package com.Target.Product.Java11;

public class Java11Points {
	public static void main(String[] args) {
		
		//Running Java Files Without Compilation (java filename.java)
		//Java 11 allows direct execution of single-file programs — no need to compile explicitly.
		
//		How Java 11 Improves Application Performance
//
//		New HTTP Client (java.net.http.HttpClient)
//
//		Supports HTTP/2, which is faster and allows multiplexing multiple requests over a single connection.
//
//		Async calls with CompletableFuture reduce blocking and improve throughput.
//
//		✅ Helps performance in microservices or API-heavy applications.
//
//		Example:
//
//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder()
//		        .uri(URI.create("https://api.example.com"))
//		        .build();
//		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//		      .thenApply(HttpResponse::body)
//		      .thenAccept(System.out::println);
//
//
//		String API Improvements
//
//		Methods like isBlank(), lines(), strip(), and repeat() are optimized, reducing manual loops and string handling overhead.
//
//		✅ Less boilerplate → faster string operations.
//
//		Files.readString() and Files.writeString()
//
//		Optimized I/O operations for reading/writing small to medium files.
//
//		✅ Simpler code + improved I/O performance vs traditional BufferedReader/FileWriter.
//
//		var in Lambdas and Local Variables
//
//		Reduces boilerplate type declarations, which makes JIT compilation slightly more efficient in some cases.
//
//		✅ Improves code readability → fewer mistakes → better maintainability → indirectly improves performance.
//
//		Garbage Collector Improvements
//
//		Java 11 supports G1 GC as default and improved ZGC (experimental).
//
//		✅ Reduces GC pause times → better throughput for large applications.
//
//		Removal of Deprecated Java EE Modules
//
//		Modules like java.xml.ws, java.corba were removed from the JDK.
//
//		✅ Smaller, lighter JDK → less memory usage → faster startup times.
//
//		Flight Recorder (JFR) Integration
//
//		Built-in profiling tool helps identify performance bottlenecks in real-time.
//
//		✅ Allows tuning of CPU/memory usage without external tools.
		
		
		
//		Flight Recorder and Mission Control (JFR)
//
//		Integrated into the OpenJDK — useful for profiling and monitoring JVM performance.
		
		
//		Key Features
//
//		Asynchronous execution
//
//		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//		    System.out.println("Task running in a separate thread");
//		});
//		future.join(); // Wait for completion
//
//
//		Return value after async computation
//
//		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5 + 10);
//		System.out.println(future.join()); // 15
//
//
//		Chaining tasks
//
//		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 5)
//		        .thenApply(n -> n * 2)   // multiply by 2
//		        .thenApply(n -> n + 10); // add 10
//		System.out.println(future.join()); // 20
//
//
//		Combining multiple futures
//
//		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
//		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
//
//		CompletableFuture<Integer> combined = f1.thenCombine(f2, (a, b) -> a + b);
//		System.out.println(combined.join()); // 30
	}
}
