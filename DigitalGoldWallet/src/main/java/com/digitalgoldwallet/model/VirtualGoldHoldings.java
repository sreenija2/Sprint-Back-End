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
@Table(name = "VIRTUAL_GOLD_HOLDINGS")
public class VirtualGoldHoldings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="holding_id")
	private int holdingid;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user1;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private VendorBranches branch1;
	@Column(name="quantity")
	private double quantity;
	@Column(name="created_At")
	private LocalDateTime createdAt;
	public int getHoldingid() {
		return holdingid;
	}
	public void setHoldingid(int holdingid) {
		this.holdingid = holdingid;
	}
	public Users getUser1() {
		return user1;
	}
	public void setUser1(Users user1) {
		this.user1 = user1;
	}
	public VendorBranches getBranch1() {
		return branch1;
	}
	public void setBranch1(VendorBranches branch1) {
		this.branch1 = branch1;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "VirtualGoldHoldings [holdingid=" + holdingid + ", user1=" + user1 + ", branch1=" + branch1
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}
