package com.onlinepizza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order1")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ORDERID1")
	private Integer orderId;
	private String orderType;
	private String orderDescription;
	private Integer customerId;
	
	/**
	 * Parameterized constructor 
	 * @param orderId
	 * @param orderType
	 * @param orderDescription
	 * @param customerId
	 */

	public Order( String orderType, String orderDescription, Integer customerId) {
		super();
		this.orderType = orderType;
		this.orderDescription = orderDescription;
		this.customerId = customerId;
	}

	/**
	 * Default constructor
	 */
	
	public Order() {
		super();
		
	}
	
	/**
	 * Getters and Setters
	 */
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * toString method
	 */ 
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderDescription=" + orderDescription
				+ ", customerId=" + customerId + "]";
	}
	
}

