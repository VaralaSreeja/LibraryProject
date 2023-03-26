package com.java.springboot.book.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.book.category.model.BookCategory;

@Repository

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
	
	List<BookCategory> findByCategory(String category);

}
