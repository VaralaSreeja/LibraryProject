package com.java.springboot.booksearch.service;

import java.util.List;

import com.java.springboot.booksearch.model.BookSearch;


public interface BookSearchService {
	
	BookSearch getBookById(long bookId);
	
	BookSearch getByBookTitle(String bookTitle);
	
	List<BookSearch> getByAuthorName(String authorName);
	
	List<BookSearch> getAllBooks();

}
