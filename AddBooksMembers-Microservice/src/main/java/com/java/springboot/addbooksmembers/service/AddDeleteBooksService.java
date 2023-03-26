package com.java.springboot.addbooksmembers.service;

import com.java.springboot.addbooksmembers.model.AddDeleteBooks;

public interface AddDeleteBooksService {
	
	AddDeleteBooks saveBook(AddDeleteBooks book);
	
	void deleteBook(long userId);

}
