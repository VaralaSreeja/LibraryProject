package com.java.springboot.book.category.service;

import java.util.List;

import com.java.springboot.book.category.model.BookCategory;


public interface BookCategoryService {
	
	List<BookCategory> getByCategory(String category);

}
