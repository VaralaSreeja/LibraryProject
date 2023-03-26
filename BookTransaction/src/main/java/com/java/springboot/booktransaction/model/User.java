package com.java.springboot.booktransaction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "phoneNumber")
	private String phoneNumber;

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

	
	public User(long userId, String userFirstName, String userlastName, String emailId, String password,
			String phoneNumber) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userlastName = userlastName;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		super();
	}



}
