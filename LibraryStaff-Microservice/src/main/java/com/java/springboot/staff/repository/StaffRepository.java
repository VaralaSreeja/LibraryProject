package com.java.springboot.staff.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.springboot.staff.model.LibStaff;

@Repository
public interface StaffRepository extends JpaRepository <LibStaff, Long> {

	LibStaff findByStaffEmailId(@Param("email") String email);

	

}
