package com.java.springboot.staff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryStaffMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryStaffMicroserviceApplication.class, args);
		System.out.println("Hello Staff");
	}

}
