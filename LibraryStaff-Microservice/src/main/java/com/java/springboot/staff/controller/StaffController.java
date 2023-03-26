package com.java.springboot.staff.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.java.springboot.staff.service.StaffService;
import com.java.springboot.staff.utils.StaffUtils;

@RestController
@RequestMapping(path = "/staff")
@CrossOrigin("http://localhost:3000/")

public class StaffController {
	
	@Autowired	
	private StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@PostMapping(path = "/signup")  
	public ResponseEntity<String> staffSignUp(@Valid @RequestBody(required = true) Map<String,String> rMap){
		
		try {
			
			return staffService.staffSignUp(rMap);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return StaffUtils.getResponseEntity("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/login")  
	public ResponseEntity<String> staffLogin(@Valid @RequestBody(required = true) Map<String,String> rMap){
		
		try {
			
			return staffService.staffLogin(rMap);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return StaffUtils.getResponseEntity("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

}
