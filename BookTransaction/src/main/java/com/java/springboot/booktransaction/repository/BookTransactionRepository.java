package com.java.springboot.booktransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.booktransaction.model.BookTransaction;

@Repository

public interface BookTransactionRepository extends JpaRepository<BookTransaction, Long> {
	

}
