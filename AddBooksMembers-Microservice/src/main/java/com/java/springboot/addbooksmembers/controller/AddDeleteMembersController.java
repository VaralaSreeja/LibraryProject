package com.java.springboot.addbooksmembers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.addbooksmembers.model.AddDeleteBooks;
import com.java.springboot.addbooksmembers.model.AddDeleteMembers;
import com.java.springboot.addbooksmembers.service.AddDeleteMembersService;



@RestController
@RequestMapping("/users")

public class AddDeleteMembersController {
	
	@Autowired	
	private AddDeleteMembersService addDltMemService;

	public AddDeleteMembersController(AddDeleteMembersService addDltMemService) {
		super();
		this.addDltMemService = addDltMemService;
	}
	
	@PostMapping("/add")  
	public ResponseEntity<AddDeleteMembers> saveMember(@RequestBody AddDeleteMembers user){
		
		return new ResponseEntity<AddDeleteMembers>(addDltMemService.saveMember(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") long userId){
		
		addDltMemService.deleteMember(userId);
		
		return new ResponseEntity<String>("Member deleted Successfully!", HttpStatus.OK);
		
	}

}
