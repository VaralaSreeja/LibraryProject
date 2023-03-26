package com.java.springboot.Reader.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.springboot.Reader.repository.UserRepository;

@Service
public class ClassService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;
	
	private com.java.springboot.Reader.model.User userDet;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		userDet = userRepo.findByEmailId(username);
		if(!Objects.isNull(userDet)) {
			
			return new User(userDet.getEmailId(),userDet.getPassword(),new ArrayList<>());	
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public com.java.springboot.Reader.model.User getUserDetail(){
		
		return userDet;
	}

}
