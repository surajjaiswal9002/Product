package com.Target.Product.FedUPI.dto;

import java.util.Objects;

import lombok.Data;

@Data
public class TransactionResponse {
	
	private int statCode;
	private String txnId;          // Unique transaction ID
    private String status;         // SUCCESS, FAILED, PENDING
    private String message;        // Any message or description
    private Double amount;
    
    
    
    public int getStatCode() {
    	return statCode;
    }
    
    public void setStatCode(int statCode) {
    	this.statCode = statCode;
    }
    

	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, message, status, txnId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionResponse other = (TransactionResponse) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(message, other.message)
				&& Objects.equals(status, other.status) && Objects.equals(txnId, other.txnId);
	}  
    
   // Transaction amount
    
    
}
