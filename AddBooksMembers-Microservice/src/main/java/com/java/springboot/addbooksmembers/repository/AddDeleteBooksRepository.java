package com.java.springboot.addbooksmembers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.addbooksmembers.model.AddDeleteBooks;

@Repository

public interface AddDeleteBooksRepository extends JpaRepository<AddDeleteBooks, Long>{

	AddDeleteBooks save(AddDeleteBooks book);

}
