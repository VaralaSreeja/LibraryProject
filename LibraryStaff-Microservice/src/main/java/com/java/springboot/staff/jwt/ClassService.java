package com.java.springboot.staff.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.java.springboot.staff.repository.StaffRepository;

@Service

public class ClassService implements UserDetailsService{
	
	@Autowired
	StaffRepository staffRepo;
	
	private com.java.springboot.staff.model.LibStaff staffDet;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		staffDet = staffRepo.findByStaffEmailId(username);
		
		if(!Objects.isNull(staffDet)) {
			
			return new User(staffDet.getEmail(),staffDet.getSpassword(),new ArrayList<>());	
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public com.java.springboot.staff.model.LibStaff getStaffDetail(){
		
		return staffDet;
	}

}
