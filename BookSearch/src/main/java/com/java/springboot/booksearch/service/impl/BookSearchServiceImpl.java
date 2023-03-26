package com.java.springboot.booksearch.service.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.booksearch.model.BookSearch;
import com.java.springboot.booksearch.repository.BookSearchRepository;
import com.java.springboot.booksearch.service.BookSearchService;
import com.java.springboot.booksearch.Exception.ResourceNotFoundException;

@Service

public class BookSearchServiceImpl implements BookSearchService{
	
	@Autowired
	private BookSearchRepository bookSearchRepo;
	

	public BookSearchServiceImpl(BookSearchRepository bookSearchRepo) {
		super();
		this.bookSearchRepo = bookSearchRepo;
	}

	@Override
	public BookSearch getByBookTitle(String bookTitle) {
		
		return bookSearchRepo.findByBookTitle(bookTitle);
	}

	@Override
	public List<BookSearch> getByAuthorName(String authorName) {
		
		return bookSearchRepo.findByAuthorName(authorName);
	}

	@Override
	public BookSearch getBookById(long bookId) {
		
		return bookSearchRepo.findById(bookId).orElseThrow(() -> 
		new ResourceNotFoundException("BookSearch","bookId",bookId));

	}

	@Override
	public List<BookSearch> getAllBooks() {
		
		return bookSearchRepo.findAll();
	}

}
