package com.java.springboot.Reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.springboot.Reader.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailId(@Param("emailId") String emailId);
}