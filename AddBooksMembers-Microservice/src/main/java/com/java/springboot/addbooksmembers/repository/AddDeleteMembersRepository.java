package com.java.springboot.addbooksmembers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.addbooksmembers.model.AddDeleteMembers;

@Repository

public interface AddDeleteMembersRepository extends JpaRepository<AddDeleteMembers, Long>{
	
	AddDeleteMembers save(AddDeleteMembers user);

}
