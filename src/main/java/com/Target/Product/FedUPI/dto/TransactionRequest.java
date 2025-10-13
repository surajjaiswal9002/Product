package com.Target.Product.FedUPI.dto;


import java.util.Objects;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionRequest {

    @NotBlank(message = "txnId is required")
    private String txnId;

    @NotNull(message = "amount is required")
    @DecimalMin(value = "0.01", message = "amount must be greater than 0")
    private Double amount;

    private String description;
    private String senderAccount;
    private String receiverAccount;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}
	public String getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, description, receiverAccount, senderAccount, txnId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionRequest other = (TransactionRequest) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(description, other.description)
				&& Objects.equals(receiverAccount, other.receiverAccount)
				&& Objects.equals(senderAccount, other.senderAccount) && Objects.equals(txnId, other.txnId);
	}
	@Override
	public String toString() {
		return "TransactionRequest [txnId=" + txnId + ", amount=" + amount + ", description=" + description
				+ ", senderAccount=" + senderAccount + ", receiverAccount=" + receiverAccount + "]";
	}
    
    
    
}

