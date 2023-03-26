package com.java.springboot.book.category.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")

public class BookCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	
	@Column(name = "Title")
	private String bookTitle;
	
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

	public BookCategory(long bookId, String bookTitle, String category, double price, long quantity) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public BookCategory() {
		
	}
	
	

}
