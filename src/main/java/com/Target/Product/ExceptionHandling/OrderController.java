package com.Target.Product.ExceptionHandling;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // GET http://localhost:8080/api/orders/0 → throws IllegalArgumentException
    // GET http://localhost:8080/api/orders/99 → throws ResourceNotFoundException
    // GET http://localhost:8080/api/orders/1 → returns success
    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id) {
        if(id.equals("0")) {
            throw new IllegalArgumentException("Order ID cannot be zero");
        }
        if(id.equals("99")) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
        return "Order details for id: " + id;
    }
    
    
    // ✅ POST API with ResponseEntity<Map>
    @PostMapping("/createOrder")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderRequestEntity orderRequest) {
        Map<String, Object> response = new HashMap<>();
        // Example validation
        if (orderRequest.getCustomerId() == null  || orderRequest.getCustomerId().isEmpty()) {
            throw new IllegalArgumentException("Customer ID is required");
        }

        // Build response map
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Order created successfully");
        response.put("data", orderRequest);  // echoing back the request as example

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

