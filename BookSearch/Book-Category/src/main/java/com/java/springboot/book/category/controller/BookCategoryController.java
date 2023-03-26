package com.java.springboot.book.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.book.category.model.BookCategory;
import com.java.springboot.book.category.service.BookCategoryService;



@RestController
@RequestMapping("/book/search")
@CrossOrigin("http://localhost:3000/")

public class BookCategoryController  {
	
	@Autowired	
	private BookCategoryService bookCategoryService;

	public BookCategoryController(BookCategoryService bookCategoryService) {
		super();
		this.bookCategoryService = bookCategoryService;
	}
	
	@GetMapping("/{category}")
	public List<BookCategory> getByCategory(@PathVariable("category") String category){
		
	return bookCategoryService.getByCategory(category);
    
	}

}
