package com.java.springboot.staff.service.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.staff.jwt.ClassService;
import com.java.springboot.staff.jwt.JwtStaffUtil;
import com.java.springboot.staff.model.LibStaff;
import com.java.springboot.staff.repository.StaffRepository;
import com.java.springboot.staff.service.StaffService;
import com.java.springboot.staff.utils.StaffUtils;

@Service
public class StaffServiceimpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	ClassService cService;
	
	@Autowired
    JwtStaffUtil jwtStaffUtil;
	
	public StaffServiceimpl(StaffRepository staffRepo) {
		super();
		this.staffRepo = staffRepo;
	}

	@Override
	public ResponseEntity<String> staffSignUp(Map<String, String> rMap) {
		
		try {
	    	
	    	if(validateStaffSignUpMap(rMap)) {
				
				LibStaff libstaff = staffRepo.findByStaffEmailId(rMap.get("email"));
				
				if(Objects.isNull(libstaff)) {
					
					staffRepo.save(getStaffFromMap(rMap));
					
					return StaffUtils.getResponseEntity("Succesfully Registered", HttpStatus.OK);
					
				}else {
					return StaffUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
				}			
			}
			else {
				return StaffUtils.getResponseEntity("Invalid Data", HttpStatus.BAD_REQUEST);
			}
	    	
	    } catch(Exception ex) {
	    	
	    	ex.printStackTrace();
	    }
	    
	    return StaffUtils.getResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

	private boolean validateStaffSignUpMap(Map<String, String> rMap) {
		
		
		if(rMap.containsKey("staffName")&& rMap.containsKey("contactNum")
				&& rMap.containsKey("email")
		   && rMap.containsKey("spassword")) {
			
			return true;
		}
		
		return false;
		
	}
	
	private LibStaff getStaffFromMap(Map<String, String> rMap) {
		
		LibStaff libstaff = new LibStaff();
		
		libstaff.setStaffName(rMap.get("staffName"));
		libstaff.setContactNum(rMap.get("contactNum"));
		libstaff.setEmail(rMap.get("email"));
		libstaff.setSpassword(rMap.get("spassword"));
		
		
		return libstaff;
	}

	@Override
	public ResponseEntity<String> staffLogin(Map<String, String> rMap) {
		
		try {
			
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(rMap.get("email"),rMap.get("spassword")));
			
			if(auth.isAuthenticated()) {
				
					return new ResponseEntity<String>("{\"token\":\""+ 
					jwtStaffUtil.generateToken(cService.getStaffDetail().getEmail()) +"\"}",HttpStatus.OK);
					
				
			}
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return new ResponseEntity<String>("{\"message\":\"" + 
				"bad credentials." + "\"}", HttpStatus.BAD_REQUEST);
	}


}
