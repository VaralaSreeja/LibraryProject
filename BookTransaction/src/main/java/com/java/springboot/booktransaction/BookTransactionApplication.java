package com.java.springboot.booktransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookTransactionApplication.class, args);
		System.out.println("This is book transaction");
	}

}
