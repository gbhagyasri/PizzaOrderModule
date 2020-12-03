package com.onlinepizza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="pizza1")
@SequenceGenerator(name="seq", initialValue=1,allocationSize=1)
public class Pizza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Id
	@Column(name="PIZZAID")
	private Integer pizzaId;
	@Column(name="PIZZATYPE")
	@NotNull(message="PizzaType cannot empty")
	private String pizzaType;
	@Column(name="PIZZANAME")
	@NotNull(message="PizzaName cannot empty")
	private String pizzaName;
	@Column(name="PIZZADESCRIPTION")
	@NotNull(message="Pizzadescription cannot empty")
	private String pizzaDescription;
	@Column(name="PIZZACOST")
	@Min(100)
	private Double pizzaCost;
	@Column(name="PIZZACOSTAFTERCOUPON")
	private Double pizzaCostAfterCoupon;
	//@OneToOne(cascade=CascadeType.ALL)
	
	/**
	 * Parameterized constructor 
	 * @param pizzaId
	 * @param pizzaType
	 * @param pizzaName
	 * @param pizzaDescription
	 * @param pizzaCost
	 * @param pizzaCostAftercoupan
	 */
	
	public Pizza( String pizzaType, String pizzaName, String pizzaDescription, Double pizzaCost,
			Double pizzaCostAfterCoupon) {
		super();
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
		this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
	}
	
	/**
	 * Default constructor
	 */
	
	public Pizza() {
		super();
		
	}

	/**
	 * Getters and Setters
	 */
	

	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(Double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public double getPizzaCostAfterCoupon() {
		return pizzaCostAfterCoupon;
	}
	public void setPizzaCostAfterCoupon(Double pizzaCostAfterCoupon) {
		this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
	}
	
	/**
	 * toString method
	 */
	
	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pizzaType=" + pizzaType + ", pizzaName=" + pizzaName
				+ ", pizzaDescription=" + pizzaDescription + ", pizzaCost=" + pizzaCost + ", pizzaCostAfterCoupon="
				+ pizzaCostAfterCoupon + "]";
	}
	
	
}
