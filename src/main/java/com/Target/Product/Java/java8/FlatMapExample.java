package com.Target.Product.Java.java8;

import java.util.*;
import java.util.stream.Collectors;


class Order {
    private String orderId;
    private List<Product> products;
    
    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }
    
    public String getOrderId() { return orderId; }
    public List<Product> getProducts() { return products; }
}

class Product {
    private String name;
    private double price;
    private String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}



public class FlatMapExample {
	public static void main(String[] args) {
		
		List<List<String>> listOfDetails = 
				Arrays.asList(Arrays.asList("mango", "banana", "orange", "mango", "orange", "orange", "banana"));
		
		
	Map<Object, Long> accurance = listOfDetails.stream()
			.flatMap(list -> list.stream())
			.collect(Collectors.groupingBy(fruits -> fruits
					, Collectors.counting()));
		System.out.println(accurance);
		
		
		List<Order> orders = Arrays.asList(
	            new Order("ORD001", Arrays.asList(
	                new Product("Laptop", 1200, "Electronics"),
	                new Product("Mouse", 25, "Electronics")
	            )),
	            new Order("ORD002", Arrays.asList(
	                new Product("Book", 15, "Books"),
	                new Product("Pen", 2, "Stationery")
	            )),
	            new Order("ORD003", Arrays.asList(
	                new Product("Phone", 800, "Electronics"),
	                new Product("Headphones", 50, "Electronics"),
	                new Product("Notebook", 5, "Stationery")
	            ))
	        );
		
		
		List<Product> list = orders.stream()
			.flatMap(Order -> Order.getProducts().stream())
			.collect(Collectors.toList());
		
		
		System.out.println(list.size()
				
				);
		
		
		
		String[][] data = {
			    {"mango", "banana"},
			    {"apple", "grapes"},
			    {"orange", "kiwi"}
			};
		
		
		// Flatten → Filter → Group by first character
		Map<Character, List<String>> result =
		        Arrays.stream(data)                   // Stream<String[]>
		                .flatMap(arr -> Arrays.stream(arr))  // Stream<String>
		                .filter(n -> n.startsWith("a"))      // filter strings starting with 'a'
		                .collect(Collectors.groupingBy(s -> s.charAt(0))); // group by first letter

		System.out.println(result);

	}
}
