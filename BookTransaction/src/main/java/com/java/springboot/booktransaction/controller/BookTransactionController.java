package com.java.springboot.booktransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.booktransaction.model.BookTransaction;
import com.java.springboot.booktransaction.service.BookTransactionService;



@RestController
@RequestMapping("/booktransaction")
@CrossOrigin("http://localhost:3000/")

public class BookTransactionController {
	
	@Autowired	
	private BookTransactionService bookTransService;

	public BookTransactionController(BookTransactionService bookTransService) {
		super();
		this.bookTransService = bookTransService;
	}
	
	@PostMapping("/{bookId}/issue/{userId}")
	
	public ResponseEntity<String> issueBook(@PathVariable("bookId") long bookId, @PathVariable("userId") long userId ){
		try {
			bookTransService.issueBook(bookId, userId);
			return ResponseEntity.ok("Book issued Successfully");
		} catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
//		 	
	}
	
	@PostMapping("/{bookId}/renew/{userId}")
	public ResponseEntity<String> renewBook(@PathVariable long bookId,@PathVariable long userId ){
		
		try {
			bookTransService.renewBook(bookId,userId);
			return ResponseEntity.ok("Book renewed successfully");
		} catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	
	}
	
	@PostMapping("/{bookId}/return")
	public ResponseEntity<String> returnBook(@PathVariable long bookId){
		
		try {
			 bookTransService.returnBook(bookId);
			 return ResponseEntity.ok("Book returned successfully");
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

}
