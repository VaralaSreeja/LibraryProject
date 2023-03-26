package com.java.springboot.book.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.book.category.model.BookCategory;
import com.java.springboot.book.category.repository.BookCategoryRepository;
import com.java.springboot.book.category.service.BookCategoryService;


@Service

public class BookCategoryServiceImpl implements BookCategoryService{
	
	@Autowired
	private BookCategoryRepository bookCategoryRepo;

	public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepo) {
		super();
		this.bookCategoryRepo = bookCategoryRepo;
	}

	@Override
	public List<BookCategory> getByCategory(String category) {
		
		return bookCategoryRepo.findByCategory(category);
	}

}
