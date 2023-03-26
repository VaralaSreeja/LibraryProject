package com.java.springboot.Reader.controller;

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

import com.java.springboot.Reader.constants.UserConstants;
import com.java.springboot.Reader.service.UserService;
import com.java.springboot.Reader.utils.UserUtils;


@RestController
@RequestMapping(path = "/user")
@CrossOrigin("http://localhost:3000/")

public class UserController {
	
	@Autowired	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
 

	@PostMapping(path = "/signup")  
	public ResponseEntity<String> signUp(@Valid @RequestBody(required = true) Map<String,String> requestMap){
		
		try {
			
			return userService.signUp(requestMap);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/login")  
	public ResponseEntity<String> login(@Valid @RequestBody(required = true) Map<String,String> requestMap){
		
		try {
			
			return userService.login(requestMap);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
