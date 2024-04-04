package com.digitalgoldwallet.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendors {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendor_id")
	private int vendorId;
	@Column(name="vendor_name")
	private String vendorName;
	@Column(name="description")
	private String description;
	@Column(name="contact_person_name")
	private String contactPersonName;
	@Column(name="contact_email")
	private String contactEmail;
	@Column(name="contact_phone")
	private String contactPhone;
	@Column(name="website_url")
	private String websiteUrl;
	@Column(name="total_gold_quantity")
	private double totalGoldQuantity;
	@Column(name="current_gold_price")
	private double currentGoldPrice;
	@Column(name="created_At")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="vendorbranch", cascade=CascadeType.ALL)
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public double getTotalGoldQuantity() {
		return totalGoldQuantity;
	}
	public void setTotalGoldQuantity(double totalGoldQuantity) {
		this.totalGoldQuantity = totalGoldQuantity;
	}
	public double getCurrentGoldPrice() {
		return currentGoldPrice;
	}
	public void setCurrentGoldPrice(double currentGoldPrice) {
		this.currentGoldPrice = currentGoldPrice;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", vendorName=" + vendorName + ", description=" + description
				+ ", contactPersonName=" + contactPersonName + ", contactEmail=" + contactEmail + ", contactPhone="
				+ contactPhone + ", websiteUrl=" + websiteUrl + ", totalGoldQuantity=" + totalGoldQuantity
				+ ", currentGoldPrice=" + currentGoldPrice + ", createdAt=" + createdAt + "]";
	}
	
	

}
