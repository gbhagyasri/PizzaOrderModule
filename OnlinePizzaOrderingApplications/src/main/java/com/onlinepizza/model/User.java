package com.onlinepizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_table")
@SequenceGenerator(name = "sequence", initialValue = 1, allocationSize = 1)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Column(name = "user_Id", length = 20)
	private Integer userId;
	@Column(name = "user_name", length = 20)
	@NotNull(message = "Name should not be Null")
	
	@Size(min = 4, max = 20)
	private String userName;

	@Column(name = "user_password", length = 20)
	@NotNull(message = "Password should not be Null")
	@Size(min = 8, max = 20)
	private String password;

	/**
	 * Default Constructor
	 * 
	 * @param string2
	 * @param string
	 * @param i
	 */
	public User() {

	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;

	}

	/**
	 * 
	 * Getters and Setters
	 */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}
