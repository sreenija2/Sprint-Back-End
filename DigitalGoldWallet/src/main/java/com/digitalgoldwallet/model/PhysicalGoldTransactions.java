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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="physical_gold_transactions")
public class PhysicalGoldTransactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private VendorBranches branch;
	
	//@NotNull(message="Quantity cannot be null")
	@Column(name="quantity")
	private double quantity;
	
	//@NotNull(message="Address cannot be null")
	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Addresses address2;
	
	@Column(name="created_At")
	private LocalDateTime createdAt;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public VendorBranches getBranch() {
		return branch;
	}
	public void setBranch(VendorBranches branch) {
		this.branch = branch;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public Addresses getAddress() {
		return address2;
	}
	public void setAddress(Addresses address) {
		this.address2 = address;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "PhysicalGoldTransactions [transactionid=" + transactionId + ", user=" + user + ", branch=" + branch
				+ ", quantity=" + quantity + ", address=" + address2 + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
	

}
