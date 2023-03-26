package com.java.springboot.addbooksmembers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.addbooksmembers.Exception.ResourceNotFoundException;
import com.java.springboot.addbooksmembers.model.AddDeleteMembers;
import com.java.springboot.addbooksmembers.repository.AddDeleteMembersRepository;
import com.java.springboot.addbooksmembers.service.AddDeleteMembersService;

@Service

public class AddDeleteMembersServiceImpl implements AddDeleteMembersService{
	
	@Autowired
	private AddDeleteMembersRepository addDltMemRepo;

	@Override
	public AddDeleteMembers saveMember(AddDeleteMembers user) {
		return addDltMemRepo.save(user);
	}

	@Override
	public void deleteMember(long userId) {
		
		addDltMemRepo.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "userId", userId));
		
		addDltMemRepo.deleteById(userId);
		
	}

}
