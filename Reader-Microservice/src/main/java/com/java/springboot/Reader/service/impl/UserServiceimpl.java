package com.java.springboot.Reader.service.impl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.java.springboot.Reader.constants.UserConstants;
import com.java.springboot.Reader.jwt.ClassService;
import com.java.springboot.Reader.jwt.JwtUtil;
import com.java.springboot.Reader.model.User;
import com.java.springboot.Reader.repository.UserRepository;
import com.java.springboot.Reader.service.UserService;
import com.java.springboot.Reader.utils.UserUtils;

import lombok.extern.slf4j.Slf4j;



@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    ClassService cService;
    
    @Autowired
    JwtUtil jwtUtil;

	public UserServiceimpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
	    try {
	    	
	    	if(validateSignUpMap(requestMap)) {
				
				User user = userRepo.findByEmailId(requestMap.get("emailId"));
				if(Objects.isNull(user)) {
					
					userRepo.save(getUserFromMap(requestMap));
					return UserUtils.getResponseEntity("Succesfully Registered", HttpStatus.OK);
					
				}else {
					return UserUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
				}
				
			}
			else {
				return UserUtils.getResponseEntity(UserConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
	    	
	    } catch(Exception ex) {
	    	
	    	ex.printStackTrace();
	    }
	    
	    return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		
		
		if(requestMap.containsKey("userFirstname")&& requestMap.containsKey("userlastName")
		   && requestMap.containsKey("phoneNumber") && requestMap.containsKey("emailId")
		   && requestMap.containsKey("password")) {
			
			return true;
		}
		
		return false;
		
	}
	
	private User getUserFromMap(Map<String, String> requestMap) {
		
		User user = new User();
		user.setUserFirstName(requestMap.get("userFirstname"));
		user.setUserlastName(requestMap.get("userlastName"));
		user.setPhoneNumber(requestMap.get("phoneNumber"));
		user.setEmailId(requestMap.get("emailId"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		
		return user;
	}


	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		
		try {
			
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password")));
			
			if(auth.isAuthenticated()) {
				
				if(cService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
				
					return new ResponseEntity<String>("{\"token\":\""+ 
					jwtUtil.generateToken(cService.getUserDetail().getEmailId()) +"\"}",HttpStatus.OK);
				} 
				else {
					
					return new ResponseEntity<String>("{\"message\":\"" + 
							"wait for admin approval." + "\"}", HttpStatus.BAD_REQUEST);
					
				}
					
				
			}
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return new ResponseEntity<String>("{\"message\":\"" + 
				"bad credentials." + "\"}", HttpStatus.BAD_REQUEST);
	}

	

}
