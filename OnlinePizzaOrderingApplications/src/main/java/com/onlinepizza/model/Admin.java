package com.onlinepizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
	@Table(name="admin_table")
    @SequenceGenerator(name = "sequence", initialValue = 1, allocationSize = 1)
	public class Admin {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
		@Column(name = "admin_Id", length = 20)
		private Integer adminId;
		@Column(name="admin_name",length=20)
	    @NotNull(message = "Name should not be Null")
	    @NotBlank(message = "Name should not be Blank")
	    @Size(min = 1, max = 20)
		private String adminType;
		 
		 @Column(name="admin_password",length=20)
		    @NotNull(message = "Password should not be Null")
		    @NotBlank(message = "Password should not be Blank")
		    @Size(min = 1, max = 20)
		private String password;
		 
		 /**
		  * Default Constructor
		  */
		public Admin() {
			
		}
		
		/**
		 * Parameterized  Constructor
		 * @param adminId
		 * @param adminType
		 * @param password
		 */
	public Admin(Integer adminId , String adminType, String password) {
		super();
		this.adminId=adminId;
		this.adminType=adminType;
		this.password=password;
		
	}
	/**
	 * 
	 * Getters and Setters
	 */
		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(Integer adminId) {
			this.adminId = adminId;
		}

		public String getAdminType() {
			return adminType;
		}

		public void setAdminType(String adminType) {
			this.adminType = adminType;
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
			return "admin [adminId=" + adminId + ", adminType=" + adminType + ", password=" + password + "]";
		}

}
