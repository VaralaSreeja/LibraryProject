package com.java.springboot.addbooksmembers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.addbooksmembers.Exception.ResourceNotFoundException;
import com.java.springboot.addbooksmembers.model.AddDeleteBooks;
import com.java.springboot.addbooksmembers.repository.AddDeleteBooksRepository;
import com.java.springboot.addbooksmembers.service.AddDeleteBooksService;

@Service

public class AddDeleteBooksSeviceImpl implements AddDeleteBooksService{
	
	@Autowired
	private AddDeleteBooksRepository addDltBooksRepo;
	
	public AddDeleteBooksSeviceImpl(AddDeleteBooksRepository addDltBooksRepo) {
		super();
		this.addDltBooksRepo = addDltBooksRepo;
	}

	@Override
	public AddDeleteBooks saveBook(AddDeleteBooks book) {
		
		return addDltBooksRepo.save(book);
	}

	@Override
	public void deleteBook(long bookId) {
		
		addDltBooksRepo.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("Books", "bookId", bookId));
		
		addDltBooksRepo.deleteById(bookId);
		
	}

}
