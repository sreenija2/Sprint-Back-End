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
@Table(name="payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user3;
	@Column(name="amount")
	private double amount;
	@Column(name="payment_method")
	private PaymentMethod paymentMethod;
	@Column(name="transaction_type")
	private TransactionType transactionType;
	@Column(name="payment_status")
	private PaymentStatus paymentStatus;
	@Column(name="created_at")
	private LocalDateTime created_At;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Users getUser3() {
		return user3;
	}
	public void setUser3(Users user3) {
		this.user3 = user3;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDateTime getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}
	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", user3=" + user3 + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", transactionType=" + transactionType + ", paymentStatus=" + paymentStatus
				+ ", created_At=" + created_At + "]";
	}
	
	

}
