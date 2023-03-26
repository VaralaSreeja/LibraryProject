package com.java.springboot.Reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReaderMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderMicroserviceApplication.class, args);
		
		System.out.println("Heyyyy Reader");
	}

}
