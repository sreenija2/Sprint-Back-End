package com.digitalgoldwallet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESSES")
public class Addresses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private int addressId;
	@Column(name="STREET")
	private String street;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@Column(name="COUNTRY")
	private String country;
	
	@OneToMany(mappedBy="address", cascade=CascadeType.ALL)
	private List<Users> users;
	
//	@OneToMany(mappedBy="address1", cascade=CascadeType.ALL)
//	private List<Vendors> vendor;
	@OneToMany(mappedBy="address2", cascade=CascadeType.ALL)
	private List<PhysicalGoldTransactions> physicalgoldtransactions;
	
	@OneToMany(mappedBy="address1", cascade=CascadeType.ALL)
	private List<VendorBranches> vendorbranches;
	
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Addresses [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}
}


