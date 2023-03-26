package com.java.springboot.booksearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.java.springboot.booksearch.model.BookSearch;
import com.java.springboot.booksearch.service.BookSearchService;


@RestController
@RequestMapping("/book/search")
@CrossOrigin("http://localhost:3000/")

public class BookSearchController {
	
	@Autowired	
	private BookSearchService bookSearchService;

	public BookSearchController(BookSearchService bookSearchService) {
		super();
		this.bookSearchService = bookSearchService;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<BookSearch> getBookById(@PathVariable("id")long bookId){
		
		return new ResponseEntity<BookSearch>(bookSearchService.getBookById(bookId),HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public List<BookSearch> getAllBooks(){	
		
		return bookSearchService.getAllBooks();
	}
	
	@GetMapping("/t/{title}")
	public BookSearch getByBookTitle(@PathVariable("title") String title){
		
		return bookSearchService.getByBookTitle(title);
		 
	}
	
	@GetMapping("/a/{author}")
	public List<BookSearch> getByAuthorName(@PathVariable("author") String authorName){
		
		return bookSearchService.getByAuthorName(authorName);
		 
	}

}
