package com.java.springboot.book.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCategoryApplication.class, args);
		
		System.out.print("book category");
	}

}
