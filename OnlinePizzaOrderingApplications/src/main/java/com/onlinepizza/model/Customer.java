package com.onlinepizza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "customer")
@SequenceGenerator(name = "sequence", initialValue = 1, allocationSize = 1)
public class Customer implements Serializable {

	/**
	 * Author Sriragavendran
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private Integer customerId;
	@Column
	@NotNull(message = "Name should not empty")
	private String customerName;
	@Column
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Enter valid mobile number")
	private String customerMobile;
	@Column
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter the valid email ")
	private String customerEmail;
	@Column
	@NotNull
	private String customerAddress;
	@Column
	@Size(min = 4, max = 6)
	private String userName;
	@Column
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}", message = "Enter the password(include atleast 1 specialCharacter and 1 number and length should be 8-20")
	private String password;

	/**
	 * Default constructor
	 */

	public Customer() {

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param customerId
	 * @param customerName
	 * @param customerMobile
	 * @param customerMail
	 * @param customerAddress
	 * @param userName
	 * @param password
	 */

	public Customer(String customerName, String customerMobile, String customerEmail, String customerAddress,
			String userName, String password) {
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

	public Integer getCustomerId() {
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

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", userName=" + userName + ", password=" + password + "]";
	}
}