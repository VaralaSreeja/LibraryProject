package com.java.springboot.booktransaction.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.java.springboot.booktransaction.model.BookTransaction;

public interface BookTransactionService {

	
	public void issueBook(long bookId, long userId);
	
	//public String renewBook(long bookId);

	//public String returnBook(long bookId);

	//String issueBook(long bookId, long userId, Date dueDate);

	//String renewBook(long bookId, LocalDate newDuedate);

	public void renewBook(long bookId, long userId);

	//void returnBook(long bookId, long userId);

	void returnBook(long bookId);

	

}