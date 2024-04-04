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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="EMAIL")
	@Email(message = "Please provide a valid email address")
	private String email;
		
	@Column(name="NAME")
	@NotBlank(message = "name cannot be blank")
	private String name;
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID")
	private Addresses address;
	@Column(name="BALANCE")
	private double balance;
	@Column(name="CREATED_AT")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	List<PhysicalGoldTransactions> physicalgoldtransactions;
	
	@OneToMany(mappedBy="user1", cascade=CascadeType.ALL)
	List<VirtualGoldHoldings> virtualgoldholdings;
	
	@OneToMany(mappedBy="user2", cascade=CascadeType.ALL)
	List<TransactionHistory> transactionhistory;
	
	@OneToMany(mappedBy="user3", cascade=CascadeType.ALL)
	List<Payments> payments;
	
	
	
	
	public Users() {
		super();
	}

	public Users(int userId, @Email(message = "Please provide a valid email address") String email,
			@NotBlank(message = "name cannot be blank") @Size(min = 3, message = "Name cannot be atleast 3 characters long") String name,
			Addresses address, double balance, LocalDateTime createdAt,
			List<PhysicalGoldTransactions> physicalgoldtransactions, List<VirtualGoldHoldings> virtualgoldholdings,
			List<TransactionHistory> transactionhistory) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.createdAt = createdAt;
		this.physicalgoldtransactions = physicalgoldtransactions;
		this.virtualgoldholdings = virtualgoldholdings;
		this.transactionhistory = transactionhistory;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Addresses getAddress() {
		return address;
	}
	public void setAddress(Addresses address) {
		this.address = address;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", address=" + address + ", balance=" + balance + ", createdAt=" + createdAt
				+ "]";
	}
}