package com.java.springboot.booksearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.booksearch.model.BookSearch;

@Repository

public interface BookSearchRepository extends JpaRepository <BookSearch, Long>{
	
	BookSearch findByBookTitle(String bookTitle);
	
	List<BookSearch> findByAuthorName(String authorName);

}
