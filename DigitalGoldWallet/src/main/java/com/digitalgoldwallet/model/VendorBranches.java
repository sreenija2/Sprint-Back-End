package com.digitalgoldwallet.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor_branches")
public class VendorBranches {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="branch_id")
	private int branchid;
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Vendors vendorbranch;
	@ManyToOne
	@JoinColumn(name="address_id")
	private Addresses address1;
	@Column(name="quantity")
	private double quantity;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="branch", cascade=CascadeType.ALL)
	List<PhysicalGoldTransactions> physicalgoldtransaction;
	
	@OneToMany(mappedBy="branch1", cascade=CascadeType.ALL)
	List<VirtualGoldHoldings> virtualgoldholding;
	
	@OneToMany(mappedBy="branch2", cascade=CascadeType.ALL)
	List<TransactionHistory> transactionhistory;
	
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	
	public Vendors getVendorbranch() {
		return vendorbranch;
	}
	public void setVendorbranch(Vendors vendorbranch) {
		this.vendorbranch = vendorbranch;
	}
	public Addresses getAddress() {
		return address1;
	}
	public void setAddress(Addresses address) {
		this.address1 = address;
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
	
	
	

}
