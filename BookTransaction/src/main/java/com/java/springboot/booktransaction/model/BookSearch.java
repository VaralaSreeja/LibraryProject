package com.java.springboot.booktransaction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")

public class BookSearch implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "bookId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	
	@Column(name = "Title")
	private String bookTitle;
	
	@Column(name = "Author")
	private String authorName;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private long quantity;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public BookSearch(long bookId, String bookTitle, String authorName, String category, double price, long quantity) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public BookSearch() {
		
	}
	
	
	

}
