package com.java.springboot.booktransaction.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.booktransaction.Exception.ResourceNotFoundException;
import com.java.springboot.booktransaction.model.BookTransaction;
import com.java.springboot.booktransaction.repository.BookTransactionRepository;
import com.java.springboot.booktransaction.service.BookTransactionService;


@Service

public class BookTransactionServiceImpl implements BookTransactionService{
	
	@Autowired
	private BookTransactionRepository bookTransactionRepo;
	

	public BookTransactionServiceImpl(BookTransactionRepository bookTransactionRepo) {
		super();
		this.bookTransactionRepo = bookTransactionRepo;
	}


	@Override
	public void issueBook(long bookId, long userId) {
		
		BookTransaction book = bookTransactionRepo.findById(bookId)
				.orElseThrow(()-> new ResourceNotFoundException("Book not Found"));
			
		if( book.getQuantity()>0) {
			
			book.setQuantity(book.getQuantity()-1);
			book.setIssued(true);
			book.setIssuedTo(userId);
			book.setIssueDate(LocalDate.now());
			book.setReturnDate(book.getIssueDate().plusDays(14));
			bookTransactionRepo.save(book);
			
			System.out.println("Book issued Successfully");
			
			
		}
		else {
			
			System.out.println("book is not available for issue");
			
		}
		
	}


	@Override
	public void renewBook(long bookId, long userId) {
		
		BookTransaction book = bookTransactionRepo.findById(bookId)
				.orElseThrow(()-> new ResourceNotFoundException("Book not Found"));
		
//		if(!book.isIssued()) {
//			return "Book is not issued";
		if(book.getReturnDate() != null) {
			
			System.out.println("Book already returned");
			
		} else {
			
			book.setDueDate(book.getReturnDate().plusDays(7));
			bookTransactionRepo.save(book);
			
			System.out.println("Book renewed successfully");
			
		}
		
	}


	@Override
	public void returnBook(long bookId) {
		
		BookTransaction book = bookTransactionRepo.findById(bookId)
				.orElseThrow(()-> new ResourceNotFoundException("Book not Found"));
		
		if(!book.isIssued()) {
			System.out.println("Book is not issued");
		}else {
			book.setQuantity(book.getQuantity()+1);
			book.setIssued(false);
			book.setIssuedTo((Long) null);
			book.setIssueDate(null);
			book.setDueDate(null);
			
			bookTransactionRepo.save(book);
			
			System.out.println("Book returned successfully");
			
		}	
		
	}

}
