package com.digitalgoldwallet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction_history")
public class TransactionHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user2;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private VendorBranches branch2;
	@Column(name="transaction_type")
	private TransactionType transactionType;
	@Column(name="transaction_status")
	private TransactionStatus transactionStatus;
	@Column(name="quantity")
	private double quantity;
	@Column(name="amount")
	private double amount;
	@Column(name="created_At")
	private LocalDateTime createdAt;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Users getUser2() {
		return user2;
	}
	public void setUser2(Users user2) {
		this.user2 = user2;
	}
	public VendorBranches getBranch2() {
		return branch2;
	}
	public void setBranch2(VendorBranches branch2) {
		this.branch2 = branch2;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", user2=" + user2 + ", branch2=" + branch2
				+ ", transactionType=" + transactionType + ", transactionStatus=" + transactionStatus + ", quantity="
				+ quantity + ", amount=" + amount + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
	
	

}
