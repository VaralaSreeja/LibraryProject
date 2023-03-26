package com.java.springboot.staff.model;

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


@NamedQuery(name = "LibStaff.findByStaffEmailId",query = "select st from LibStaff st where st.email =: email")

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "Staff")

public class LibStaff implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staffId")
	private long staffId;
	
	@Column(name = "staffName", nullable = false)
	private String staffName;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Size(min=6, message = "Password should be atleast 6 characters")
	@Column(name = "spassword")
	private String spassword;
	
	@Size(min=10, message = "Contact number should be atleast 10 characters")
	@Column(name = "contactNum")
	private String contactNum;

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public LibStaff(long staffId, String staffName, @Email String email,
			@Size(min = 6, message = "Password should be atleast 6 characters") String spassword,
			@Size(min = 10, message = "Contact number should be atleast 10 characters") String contactNum) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.email = email;
		this.spassword = spassword;
		this.contactNum = contactNum;
	}

	public LibStaff() {
		
	}
	
	

}
