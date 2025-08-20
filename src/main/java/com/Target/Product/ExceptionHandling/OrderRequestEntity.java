package com.Target.Product.ExceptionHandling;

public class OrderRequestEntity {
	private String customerId;
	private String product;
	private int quantity;
	
	// getter
	public String getCustomerId() {
		return customerId;
	}
	
	public String getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	// setter
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// constructor
	public OrderRequestEntity(String customerId, String product, int quantity) {
		this.customerId = customerId;
		this.product = product;
		this.quantity = quantity;
	}
	
}
