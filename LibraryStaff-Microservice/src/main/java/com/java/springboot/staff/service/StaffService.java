package com.java.springboot.staff.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.java.springboot.staff.model.LibStaff;

public interface StaffService {
	
	public ResponseEntity<String> staffSignUp(Map<String, String> rMap);
	
	public ResponseEntity<String> staffLogin(Map<String, String> rMap);

	


}
