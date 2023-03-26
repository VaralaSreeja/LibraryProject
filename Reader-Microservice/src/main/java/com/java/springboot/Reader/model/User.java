package com.java.springboot.Reader.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@NamedQuery(name = "User.findByEmailId",query = "select u from User u where u.emailId =: emailId")


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "User")

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "firstName")
	private String userFirstName;
	
	@Column(name = "lastName")
	private String userlastName;
	
	@Email
	@Column(name = "emailId")
	private String emailId;
	
	@Size(min=6, message = "Password should be atleast 6 characters")
	@Column(name = "password")
	private String password;
	
	@Size(min=10, message = "Contact number should be atleast 10 characters")
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	
	private String status;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserlastName() {
		return userlastName;
	}

	public void setUserlastName(String userlastName) {
		this.userlastName = userlastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public User(long userId, String userFirstName, String userlastName, @Email String emailId,
			@Size(min = 6, message = "Password should be atleast 6 characters") String password,
			@Size(min = 10, message = "Contact number should be atleast 10 characters") String phoneNumber,
			String status) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userlastName = userlastName;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public User() {
		super();
	}



}
