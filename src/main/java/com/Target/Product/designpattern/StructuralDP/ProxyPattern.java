package com.Target.Product.designpattern.StructuralDP;

import java.util.HashMap;
import java.util.Map;

// Proxy is a structure DP, > Proxy acts as a middle layer between client and actual service.
//For example, in Walmart’s system, instead of calling the backend every time to get product info, 
//we can use a proxy that checks a cache first.
//If data is already there, it returns it instantly — saving time and reducing load on the backend.”

//Step 1: Real subject (the actual service)
interface ProductService {
 String getProductDetails(String productId);
}

class RealProductService implements ProductService {
 public String getProductDetails(String productId) {
     System.out.println("Fetching product details from backend...");
     return "Product details for " + productId;
 }
}

//Step 2: Proxy class
class ProductServiceProxy implements ProductService {
 private RealProductService realService = new RealProductService();
 private Map<String, String> cache = new HashMap<>();

 public String getProductDetails(String productId) {
     if (cache.containsKey(productId)) {
         System.out.println("Returning cached product details...");
         return cache.get(productId);
     } else {
         String details = realService.getProductDetails(productId);
         cache.put(productId, details);
         return details;
     }
 }
}

//Step 3: Client
public class ProxyPattern {
 public static void main(String[] args) {
     ProductService productService = new ProductServiceProxy();

     System.out.println(productService.getProductDetails("TV001"));
     System.out.println(productService.getProductDetails("TV001")); // uses cache
 }
}




