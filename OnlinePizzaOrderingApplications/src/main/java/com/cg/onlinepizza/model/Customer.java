package com.cg.onlinepizza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	private Integer customerId;
	@Column(length=10)
	private String customerName;
	@Column(length=10)
	private Long customerMobile;
	@Column(length=10)
	private String customerEmail;
	@Column(length=10)
	private String customerAddress;
	@Column(length=10)
	private String userName;
	@Column(length=10)
	private String password;
	
	/**
	 * Default constructor
	 */
	
	public Customer() {
		
	}
	
	/**
	 * Parameterized constructor 
	 * @param customerId
	 * @param customerName
	 * @param customerMobile
	 * @param customerMail
	 * @param customerAddress
	 * @param userName
	 * @param password
	 */

	public Customer(String customerName, Long customerMobile, String customerEmail,
			String customerAddress, String userName, String password) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.userName = userName;
		this.password = password;
	}
	/**
	 * Getters and Setters
	 * 
	 */

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * toString method
	 */
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", userName=" + userName + ", password=" + password + "]";
	}

}