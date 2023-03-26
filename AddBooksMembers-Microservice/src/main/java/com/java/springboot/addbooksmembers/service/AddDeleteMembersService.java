package com.java.springboot.addbooksmembers.service;

import com.java.springboot.addbooksmembers.model.AddDeleteMembers;

public interface AddDeleteMembersService {
	
	AddDeleteMembers saveMember(AddDeleteMembers user);
	
	void deleteMember(long userId);

}
