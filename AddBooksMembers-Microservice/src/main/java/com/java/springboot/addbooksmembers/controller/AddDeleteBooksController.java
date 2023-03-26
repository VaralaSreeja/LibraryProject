package com.java.springboot.addbooksmembers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.addbooksmembers.model.AddDeleteBooks;
import com.java.springboot.addbooksmembers.service.AddDeleteBooksService;


@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:3000/")

public class AddDeleteBooksController {
	
	@Autowired	
	private AddDeleteBooksService addDltBookService;

	public AddDeleteBooksController(AddDeleteBooksService addDltBookService) {
		super();
		this.addDltBookService = addDltBookService;
	}
	
	@PostMapping("/add")  
	public ResponseEntity<AddDeleteBooks> saveBook(@RequestBody AddDeleteBooks book){
		
		return new ResponseEntity<AddDeleteBooks>(addDltBookService.saveBook(book), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long bookId){
		
		addDltBookService.deleteBook(bookId);
		return new ResponseEntity<String>("Book deleted Successfully!", HttpStatus.OK);
		
	}


}
