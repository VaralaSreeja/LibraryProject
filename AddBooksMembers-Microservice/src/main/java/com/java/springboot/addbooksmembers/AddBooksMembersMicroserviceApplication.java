package com.java.springboot.addbooksmembers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddBooksMembersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddBooksMembersMicroserviceApplication.class, args);
		System.out.println("Add members and books");
	}

}
