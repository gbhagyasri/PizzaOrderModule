package com.cg.onlinepizza.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "PizzaOrder1")
public class PizzaOrder implements Serializable {
	
	/**
	 * Author G Bhagya Sri 
	 * 
	 */
	
	/**
	 * Data fields for  PizzaOrder 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	@NotNull(message = "Size cannot be Empty")
	private String size1;
	@Min(1)
	@Max(15)
	private Integer quantity1;
	@Min(200)
	private Double totalCost;
	@NotNull(message = "Transaction Mode Should be selected")
	private String transactionMode;
	
	private LocalDate orderDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PIZZA_ID")
	private Pizza pizza;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")                       
	private Order order2;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="COUPAN_ID")
	private Coupan coupan;  
//	
	/**
	 * Default constructor
	 */
	public PizzaOrder() {
	
	}
	
	/**
	 * Parameterized constructor 
	 * @param Size1
	 * @param quantity1
	 * @param totalCost
	 * @param transactionMode
	 * @param pizza
	 * @param order2
	 * @param coupan
	 */
	
	public PizzaOrder( String size1,int quantity1,double totalCost,String transactionMode,LocalDate orderDate,Pizza pizza,Order order2,Coupan coupan)
	 {
		super();
		this.size1 = size1;
		this.quantity1 = quantity1;
		this.totalCost = totalCost;
		this.transactionMode = transactionMode;
		 this.order2=order2; 
		this.coupan=coupan;
		this.pizza=pizza;
		this.orderDate=orderDate;
		
	}

	/**
	 * Getters and Setters
	 */
	
	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public String getSize1() {
		return size1;
	}

	public void setSize1(String size1) {
		this.size1 = size1;
	}

	public Integer getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(Integer quantity1) {
		this.quantity1 = quantity1;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}


	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
}


  public Order getOrder2()
  { 
	  return order2;
  }
  
  public void setOrder2(Order order) {
	  this.order2 = order; 
	  }
 

	public Coupan getCoupan() {
	return coupan;
	}

	public void setCoupan(Coupan coupan) {
		this.coupan = coupan;
      }
	public LocalDate getOrderdate() {
		return orderDate;
	}

	public void setOrderdate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * toString method
	 */

	@Override
	public String toString() {
		return "PizzaOrder [bookingOrderId=" + bookingOrderId + ", size1=" + size1 + ", quantity1=" + quantity1
				+ ", totalCost=" + totalCost + ", transactionMode=" + transactionMode + ", orderDate=" + orderDate
				+ ", pizza=" + pizza + ", order2=" + order2 + ", coupan=" + coupan + "]";
	}

	

	
	
}
